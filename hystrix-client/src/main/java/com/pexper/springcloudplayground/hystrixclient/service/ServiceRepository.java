package com.pexper.springcloudplayground.hystrixclient.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.pexper.springcloudplayground.hystrixclient.repository.RepositoryServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceRepository {

    @Autowired
    private RepositoryServiceClient repositoryServiceClient;

    @HystrixCommand(fallbackMethod = "defaultServiceUrl")
    public String getServiceURL(String appName) {
        return repositoryServiceClient.getServiceURL(appName);
    }

    public String defaultServiceUrl(String appName) {
        return "invalid url, cirtuit is open!";
    }

}
