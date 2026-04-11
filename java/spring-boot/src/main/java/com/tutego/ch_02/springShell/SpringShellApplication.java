package com.tutego.ch_02.springShell;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringShellApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringShellApplication.class);

    public static void main(String... args) {
        SpringApplication.run(com.tutego.ch_02.dependencyInjection.FsCommands.class, args);
        logger.info("Spring Shell blocks upon the application initialization, resumes upon closing..");
    }
}
