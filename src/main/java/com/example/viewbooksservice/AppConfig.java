package com.example.viewbooksservice;

import com.example.viewbooksservice.listeners.DefaultListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.support.RetryTemplate;

@Configuration
@EnableRetry
public class AppConfig {

    @Bean
    public RetryTemplate retryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();
        System.out.println("process configuration");

        retryTemplate.registerListener(new DefaultListener());

        return retryTemplate;
    }
}
