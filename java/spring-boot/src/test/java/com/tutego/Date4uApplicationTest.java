package com.tutego;

import com.tutego.ch_02.classpathScanning.Date4uApplication;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;

@TestPropertySources(
        value = { // alternative way of changing test configuration, doesn't require loading the full Spring context
                @TestPropertySource(locations = "classpath:test.properties"), // !!!! cannot parse YAML from here !!!!
                @TestPropertySource(properties = "spring.shell.interactive.enabled=false")
        }
)
@SpringBootTest(
        properties = "spring.shell.interactive.enabled=false", /* cannot set locations from here */
        classes = Date4uApplication.class
)
public class Date4uApplicationTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${com.tutego.homepage}")
    private String homepage;

    @Value("${com.tutego.number-of-seminars}")
    private int numberOfSeminars;

    @Test
    public void loadContext() {
        logger.info("homepage: {}", homepage);
        logger.info("numberOfSeminars: {}", numberOfSeminars);
    }

}
