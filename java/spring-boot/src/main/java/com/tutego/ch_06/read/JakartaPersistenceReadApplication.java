package com.tutego.ch_06.read;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = JakartaPersistenceReadModule.class)
public class JakartaPersistenceReadApplication {

    public static void main(String... args) {
        SpringApplication.run(JakartaPersistenceReadApplication.class, args);
    }

}
