package com.ezlearning.platform.services.aws.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.ezlearning.platform.services.aws.AmazonS3ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URL;


@Service
@Slf4j
public class AmazonS3ClientServiceImpl implements AmazonS3ClientService {

    @Value("${aws.s3.bucket}")
    String bucketName;

    private AmazonS3 s3Client;

    public AmazonS3ClientServiceImpl(AmazonS3 s3Client) {
        this.s3Client = s3Client;
    }

    @Override
    public int createBucket() {
        int response;

        try {
            if (!s3Client.doesBucketExistV2(bucketName)) {
                CreateBucketRequest request = new CreateBucketRequest(bucketName)
                        .withCannedAcl(CannedAccessControlList.BucketOwnerFullControl);
                s3Client.createBucket(request);
                response = 0;
            } else {
                response = 1;
            }
        } catch (Exception e) {
            log.error("Error creating bucket: {}", e.getMessage());
            response = 1;
        }

        return response;
    }

    @Override
    public URL upload(File file, String filename) {
        URL response = null;
        log.info("Inside upload method");

        try {
            log.info("Checking if object exists");
            if (!s3Client.doesObjectExist(bucketName, filename)) {
                log.info("Making request");
                PutObjectRequest request = new PutObjectRequest(bucketName, filename, file)
                        .withCannedAcl(CannedAccessControlList.PublicRead);
                log.info("sending request");
                s3Client.putObject(request);
                log.info("getting url");
                response = s3Client.getUrl(bucketName, filename);
            }
        } catch (Exception e) {
            log.error("Error uploading file: {}", e.getMessage());
        }

        return response;

    }
}
