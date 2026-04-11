package com.tutego.ch_02.configurationClasses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = ConfigurationClasses.class)
public class ConfigurationClassesApplication {

    public static void main(String... args) {
        SpringApplication.run(ConfigurationClassesApplication.class, args);
    }
}
