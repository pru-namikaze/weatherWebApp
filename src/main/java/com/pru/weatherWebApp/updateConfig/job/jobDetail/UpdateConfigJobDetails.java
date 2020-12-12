package com.pru.weatherWebApp.updateConfig.job.jobDetail;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;

public class UpdateConfigJobDetails {

    public static JobDetail setJobDetails(Class jobClass) {
        return JobBuilder
                .newJob()
                .withIdentity(jobClass.getSimpleName())
                .setJobData(
                        new JobDataMap() {{
                            put(jobClass.getSimpleName(), "hello");
                        }}
                )
                .build();

    }
}
