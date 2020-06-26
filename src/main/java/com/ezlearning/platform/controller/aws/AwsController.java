package com.ezlearning.platform.controller.aws;

import com.ezlearning.platform.services.aws.AmazonS3ClientService;
import com.ezlearning.platform.services.aws.AmazonSqsClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aws")
@Slf4j
public class AwsController {

    AmazonS3ClientService s3Service;
    AmazonSqsClientService sqsService;


    public AwsController(AmazonS3ClientService service) {
        this.s3Service = service;
    }

    @GetMapping("/createbucket")
    String createBucket() {
        log.info("Get request to /aws/createbucket");
        return s3Service.checkS3Bucket();
    }

    @GetMapping("/createqueue")
    String createQueue() {
        log.info("Get request to /aws/createqueue");
        return sqsService.createQueue();
    }
}
