package com.tutego.ch_04.retry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class RetryApplication {

    private static final Logger logger = LoggerFactory.getLogger(RetryApplication.class);

    public RetryApplication(RandomPhoto randomPhoto)  {
        logger.info("RandomPhoto proxy: {}", randomPhoto.getClass().getName());

        try {
            var json = randomPhoto.receive("male");
            logger.info("received json: {}", json);
        } catch (Exception exception) {
            logger.info("exception: {}", exception.getMessage());
        }

    }

    public static void main(String... args) {
        SpringApplication.run(RetryApplication.class, args);
    }
}
