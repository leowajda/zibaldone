package com.tutego.ch_04.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ConfigurationPropertiesScan
@SpringBootApplication(scanBasePackageClasses = ValidationModule.class)
public class ValidationApplication {

    private static final Logger logger = LoggerFactory.getLogger(ValidationApplication.class);

    // when a Jakarta Bean Validator implementation is present in the classpath,
    // Spring autoconfiguration constructs a Validator as a managed bean that can be injected by a client for use
    public ValidationApplication(
            jakarta.validation.Validator validator,
            PhotoService photoService,
            GeometryProperties geometryProperties
    ) {
        logger.info("PhotoService proxy: {}", photoService.getClass().getName());
        var photo = new Photo(
                1L,
                -1L,
                "äöü",
                false,
                LocalDateTime.now().plusDays(1)
        );

        var errors = validator.validate(photo); // manually validate input
        logger.info("errors: {}", errors.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(", ")));

        try { // validate input declaratively
            photoService.checkValidity(photo);
        } catch (ConstraintViolationException exception) {
            logger.info("proxy has rejected photo: {}", photo);
        }

        try { // validate output declaratively
            photoService.invalidOutput();
        } catch (ConstraintViolationException exception) {
            logger.info("invalid return value for call: 'photoService.invalidOutput()'");
        }

        // validate configuration declaratively
        logger.info("geometryProperties: {}", geometryProperties);

    }

    public static void main(String... args) {
        SpringApplication.run(ValidationApplication.class, args);
    }
}
