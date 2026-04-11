package com.tutego.ch_03.externalConfiguration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan // looks for @ConfigurationProperties, works similarly to @ComponentScan
@SpringBootApplication(scanBasePackageClasses = ExternalConfigurationModule.class)
public class ExternalConfigurationApplication {

    private static final Logger logger = LoggerFactory.getLogger(ExternalConfigurationApplication.class);

    public static void main(String... args) {
        var ctx = SpringApplication.run(ExternalConfigurationApplication.class, args);
        var env = ctx.getEnvironment();

        env.getPropertySources()
                .forEach(propSource -> logger.info("{}= \n{}", propSource, propSource.getSource()));

        logger.info("secure-random.int={}", env.getProperty("secure-random.int"));
        logger.info("secure-random.long={}", env.getProperty("secure-random.long"));

    }
}
