package com.tutego.ch_06.write;

import com.tutego.ch_06.read.JakartaPersistenceReadModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackageClasses = {
                JakartaPersistenceWriteModule.class,
                JakartaPersistenceReadModule.class
})
public class JakartaPersistenceWriteApplication {

    public static void main(String... args) {
        SpringApplication.run(JakartaPersistenceWriteApplication.class, args);
    }

}
