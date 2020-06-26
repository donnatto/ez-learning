package com.ezlearning.platform.services.aws.impl;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import com.ezlearning.platform.services.aws.AmazonSqsClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AmazonSqsClientServiceImpl implements AmazonSqsClientService {

    @Value("${aws.queue.name}")
    private String queueName;

    private AmazonSQS sqsClient;

    public AmazonSqsClientServiceImpl(AmazonSQS sqsClient) {
        this.sqsClient = sqsClient;
    }

    @Override
    public String createQueue() {

        CreateQueueResult res = sqsClient.createQueue(queueName);
        return res.getQueueUrl();

    }
}
