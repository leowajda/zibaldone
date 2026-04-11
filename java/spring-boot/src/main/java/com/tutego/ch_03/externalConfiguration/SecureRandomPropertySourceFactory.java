package com.tutego.ch_03.externalConfiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.lang.Nullable;

import java.security.SecureRandom;

@Configuration
@org.springframework.context.annotation.PropertySource(value = "", factory = SecureRandomPropertySourceFactory.class)
class SecureRandomPropertySourceFactory implements PropertySourceFactory {

    private final SecureRandom random = new SecureRandom();

    @Override
    public PropertySource<?> createPropertySource(@Nullable String name, EncodedResource resource) {
        return new PropertySource<>("secure-random") {

            @Override
            public Object getProperty(String name) {
                return switch (name) {
                    case "secure-random.int" -> random.nextInt();
                    case "secure-random.long" -> random.nextLong();
                    default -> null;
                };
            }
        };

    }
}
