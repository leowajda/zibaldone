package com.tutego.ch_09;

import com.tutego.ch_07.SpringDataJpaModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackageClasses = {
                WebModule.class,
                SpringDataJpaModule.class
        }
)
public class WebApplication {

    public static void main(String... args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
