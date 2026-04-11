package com.tutego.ch_03.internationalization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;

@SpringBootApplication(scanBasePackageClasses = InternationalizationModule.class)
public class InternationalizationApplication {

    private static final Logger logger = LoggerFactory.getLogger(InternationalizationApplication.class);

    // Spring utility class (avoids Locale boilerplate)
    private final MessageSourceAccessor messageSourceAccessor;

    public InternationalizationApplication(MessageSource messageSource) {
        this.messageSourceAccessor = new MessageSourceAccessor(messageSource);
        logger.info(messageSourceAccessor.getMessage("shell.fs.path-exist", new Object[]{"some-argument"}));
        logger.info(messageSourceAccessor.getMessage("shell.fs.path-not-exist", new Object[]{"some-other-argument"}));
    }

    public static void main(String... args) {
        SpringApplication.run(InternationalizationApplication.class, args);
    }

}
