package com.tutego.ch_02.dependencyInjection;

import com.tutego.ch_02.classpathScanning.ClassPathScanning;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {DependencyInjection.class, ClassPathScanning.class})
public class DependencyInjectionApplication {

    public static void main(String... args) {
        SpringApplication.run(DependencyInjectionApplication.class, args);
    }
}
