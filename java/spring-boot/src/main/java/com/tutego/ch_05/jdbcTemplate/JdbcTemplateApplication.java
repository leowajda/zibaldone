package com.tutego.ch_05.jdbcTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = JdbcTemplateModule.class)
public class JdbcTemplateApplication {

    private static final Logger logger = LoggerFactory.getLogger(JdbcTemplateApplication.class);

    public static void main(String... args) {
        SpringApplication.run(JdbcTemplateApplication.class, args);
    }

}
