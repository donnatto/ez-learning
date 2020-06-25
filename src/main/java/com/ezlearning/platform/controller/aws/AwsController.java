package com.ezlearning.platform.controller.aws;

import com.ezlearning.platform.services.aws.AmazonS3ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aws")
@Slf4j
public class AwsController {

    AmazonS3ClientService service;

    public AwsController(AmazonS3ClientService service) {
        this.service = service;
    }

    @GetMapping("/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    String createBucket() {
        log.info("/aws/create");
        return service.checkS3Bucket();
    }
}
