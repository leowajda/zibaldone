package com.tutego.ch_02.autoConfiguration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(ConditionalConfiguration.class);

    private static class A {
        public A() {
            logger.info("bean: a has been created");
        }
    }

    @Bean
    @ConditionalOnExpression("1+1==2")
    public A conditionalBeanOne() {
        return new A();
    }

    @Bean
    @ConditionalOnProperty(name = "conditional.property", havingValue = "true")
    public A conditionalBeanTwo() {
        return new A();
    }

}
