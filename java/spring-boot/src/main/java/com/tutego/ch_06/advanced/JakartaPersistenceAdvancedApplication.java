package com.tutego.ch_06.advanced;

import com.tutego.ch_06.read.JakartaPersistenceReadModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackageClasses = {
                JakartaPersistenceAdvancedModule.class,
                JakartaPersistenceReadModule.class
        }
)
public class JakartaPersistenceAdvancedApplication {

    public static void main(String... args) {
        SpringApplication.run(JakartaPersistenceAdvancedApplication.class, args);
    }

}
