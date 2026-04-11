package com.tutego.ch_03.scheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling // configures a ScheduledAnnotationBeanPostProcessor, applicable on @Configuration beans
@SpringBootApplication(scanBasePackageClasses = SchedulingModule.class)
public class SchedulingApplication {

    // https://docs.spring.io/spring-boot/reference/io/quartz.html
    public static void main(String... args) {
        SpringApplication.run(SchedulingApplication.class, args);
    }
}
