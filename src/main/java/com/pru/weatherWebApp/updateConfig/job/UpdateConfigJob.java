package com.pru.weatherWebApp.updateConfig.job;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UpdateConfigJob implements Job {

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.info("UpdateConfigJob Triggered Job");
        try {
            HttpResponse<String> response = Unirest.post("http://localhost:8080/actuator/refresh").asString();
            logger.info("response Body: " + response.getBody());
            logger.info("UpdateConfigJob Triggered Job Completed Successfully");
        } catch (UnirestException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
