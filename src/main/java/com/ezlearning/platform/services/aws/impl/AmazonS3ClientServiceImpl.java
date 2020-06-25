package com.ezlearning.platform.services.aws.impl;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.ezlearning.platform.services.aws.AmazonS3ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Service
@Slf4j
public class AmazonS3ClientServiceImpl implements AmazonS3ClientService {

    @Value("${AWS_ACCESS_KEY}")
    private String accessKey;
    @Value("${AWS_SECRET_KEY}")
    private String secretKey;
    @Value("${AWS_REGION}")
    private String region;
    @Value("${AWS_BUCKET_NAME}")
    String bucketName;

    private AmazonS3 s3Client;

    @PostConstruct
    public void getAmazonS3Client() {
        final BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        s3Client = AmazonS3ClientBuilder
                .standard()
                .withRegion(Regions.fromName(region))
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    }

    @Override
    public String checkS3Bucket() {
        String response = null;

        boolean bucketExistV2 = s3Client.doesBucketExistV2(bucketName);

        if (!bucketExistV2) {
            log.info("Bucket no existe");
            response = "No existe: " + bucketName;
        } else {
            log.info("Bucket existente");
            response = "Bucket existente: " + bucketName;
        }

        return response;
    }
}
