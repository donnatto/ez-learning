package com.ezlearning.platform.services.aws;

import java.io.File;
import java.net.URL;

public interface AmazonS3ClientService {

    int createBucket();
    URL upload(File file, String string);
}
