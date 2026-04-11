package com.tutego.ch_04.caching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

// defaults to java.util.concurrent.ConcurrentHashMap configurable through auto-configuration
@EnableCaching
@SpringBootApplication(scanBasePackageClasses = CachingModule.class)
public class CachingApplication {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final HotProfileToJsonConverter converter;

    public CachingApplication(HotProfileToJsonConverter converter) {
        // https://github.com/cglib/cglib
        // com.tutego.ch_04.caching.HotProfileToJsonConverter$$SpringCGLIB$$0
        logger.info("proxied bean: {}", converter.getClass().getName());
        this.converter = converter;
    }

    @Bean
    public ApplicationRunner runAtStartTime() {
        return args -> {
            var firstCall = converter.hotAsJson(Arrays.asList(1L, 2L, 3L));
            var secondCachedCall = converter.hotAsJson(Arrays.asList(1L, 2L, 3L));
        };
    }

    public static void main(String... args) {
        SpringApplication.run(CachingApplication.class, args);
    }

}
