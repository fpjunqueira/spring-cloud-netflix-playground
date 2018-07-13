package com.pexper.springcloudplayground.hystrixclient.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.pexper.springcloudplayground.hystrixclient.service.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

    @Autowired
//    private ServiceRepository serviceRepository;
    private ServiceRepository serviceRepository;

    @GetMapping("/eureka-client-repository-url/{eurekaClientName}")
    @HystrixCommand(fallbackMethod = "defaultServiceUrl")
    public @ResponseBody String getServiceURLFromEurikaClient(@PathVariable String eurekaClientName) {
//        return serviceRepository.getServiceURL(eurekaClientName);
        return serviceRepository.getServiceURL(eurekaClientName);
    }

    public String defaultServiceUrl(String appName) {
        return "invalid url, cirtuit is open!";
    }

}
