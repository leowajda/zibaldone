package com.tutego.ch_02.configurationClasses.injectionPoint;

import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.lang.reflect.AnnotatedElement;
import java.security.SecureRandom;
import java.util.Random;

import static java.util.Objects.nonNull;

@Configuration
public class RandomConfiguration {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // <- bean doesn't get memoized
    public Random random(InjectionPoint injectionPoint) {
        return nonNull(injectionPoint.getAnnotation(CryptographicallyStrong.class)) || (injectionPoint.getMember() instanceof AnnotatedElement member && member.isAnnotationPresent(CryptographicallyStrong.class)) ? new SecureRandom() : new Random();
    }

}
