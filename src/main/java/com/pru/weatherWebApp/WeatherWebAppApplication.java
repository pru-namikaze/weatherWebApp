package com.pru.weatherWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableEurekaClient
@EnableScheduling
@Async
public class WeatherWebAppApplication {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Async
    @Scheduled(cron = "${updateConfigCronJobScheduleString}")
    public void UpdateConfig() {
        System.out.println(LocalDateTime.now() + "updated");
    }

    public static void main(String[] args) {
        SpringApplication.run(WeatherWebAppApplication.class, args);
    }
}
