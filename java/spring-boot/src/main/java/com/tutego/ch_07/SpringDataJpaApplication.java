package com.tutego.ch_07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringDataJpaApplication {
    private final Logger log = LoggerFactory.getLogger(getClass());

    public SpringDataJpaApplication(ProfileRepository profiles) {
        log.info("Profile with id=1: {}", profiles.findById(1L));
        log.info("All profiles: {}", profiles.findAll());
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }
}