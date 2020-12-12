package com.pru.weatherWebApp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
@EnableEurekaClient
public class WeatherWebApplicationController {

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${indexPageGreeting}")
    private
    String indexPageGreeting;

    @RequestMapping("/")
    public String index() {
        try {
            logger.info("Index Page is Hit");
            return indexPageGreeting;
            //return (String) ((HashMap) (((HashMap) ((ArrayList) (restTemplate.getForObject("http://weatherWebApplicationCloudConfigurationServer/application/default", HashMap.class)).get("propertySources")).get(0)).get("source"))).get("indexPageGreeting");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return "error";
    }

}
