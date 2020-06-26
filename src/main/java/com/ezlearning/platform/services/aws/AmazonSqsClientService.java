package com.ezlearning.platform.services.aws;

import com.amazonaws.services.sqs.AmazonSQS;

public interface AmazonSqsClientService {

    String createQueue();
}
