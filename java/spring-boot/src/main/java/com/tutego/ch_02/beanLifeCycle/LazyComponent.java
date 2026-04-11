package com.tutego.ch_02.beanLifeCycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

// if spring.main.lazy-initialization: true, @Lazy(true) will evaluate this component eagerly instead.
@Lazy(false)
@Component
public class LazyComponent {

    private static final Logger logger = LoggerFactory.getLogger(LazyComponent.class);

    public LazyComponent() {
        logger.info(LazyComponent.class.getName() + " is being initialized");
    }

    @PostConstruct
    public void postConstruct() {
        logger.info("postConstruct call for bean: " + LazyComponent.class.getName());
    }

    @PreDestroy
    public void preDestroy() {
        logger.info("preDestroy call for bean " + LazyComponent.class.getName());
    }

}
