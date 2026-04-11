package com.tutego.ch_04.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync // backed by a thread-pool (configurable by AsyncConfigurer)
@SpringBootApplication(scanBasePackageClasses = AsyncModule.class)
public class AsyncApplication {

    private static final Logger logger = LoggerFactory.getLogger(AsyncApplication.class);

    public static void main(String... args) {
        SpringApplication.run(AsyncApplication.class, args);
    }

    @Bean
    public ApplicationRunner runAtStartTime(SleepAndDream sleepAndDream) {
        return args -> {
            sleepAndDream.sleepAsyncVoid();
            sleepAndDream.sleepAsyncString();
        };
    }

}
