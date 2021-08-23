package com.example.viewbooksservice;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Slf4j
public class ViewBooksServiceApplication {
//    private static final Logger logger = LoggerFactory.getLogger(ViewBooksServiceApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(ViewBooksServiceApplication.class, args);
        log.info("application is ready to use");
    }

}
