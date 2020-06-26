package com.ezlearning.platform.controller.aws;

import com.ezlearning.platform.services.aws.AmazonSqsClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/sqs")
@RestController
@PreAuthorize("hasRole('ROLE_USER')")
@Slf4j
public class AwsSqsController {

    AmazonSqsClientService sqsService;

    public AwsSqsController(AmazonSqsClientService sqsService) {
        this.sqsService = sqsService;
    }

    @GetMapping("/createqueue")
    String createQueue() {
        log.info("Get request to /aws/createqueue");
        return sqsService.createQueue();
    }


}
