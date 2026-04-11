package com.tutego.ch_02.beanLifeCycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrePostBean {

    private static final Logger logger = LoggerFactory.getLogger(PrePostBean.class);

    private class Foo {
        private void initMethod() {
            logger.info("initMethod call for bean: " + Foo.class.getName());
        }

        private void destroyMethod() {
            logger.info("destroyMethod call for bean: " + Foo.class.getName());
        }
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public Foo uuid() {
        return new Foo();
    }


}
