package com.tutego.ch_09.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = SecurityModule.class)
public class SecurityApplication {

    public static void main(String... args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

}
