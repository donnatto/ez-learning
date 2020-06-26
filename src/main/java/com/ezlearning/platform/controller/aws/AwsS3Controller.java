package com.ezlearning.platform.controller.aws;

import com.ezlearning.platform.services.aws.AmazonS3ClientService;
import com.ezlearning.platform.services.aws.AmazonSqsClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/s3")
@PreAuthorize("hasRole('ROLE_USER')")
@Slf4j
public class AwsS3Controller {

    AmazonS3ClientService s3Service;


    public AwsS3Controller(AmazonS3ClientService service) {
        this.s3Service = service;
    }

    @GetMapping("/createbucket")
    int createBucket() {
        log.info("Get request to /aws/createbucket");
        return s3Service.createBucket();
    }

}
