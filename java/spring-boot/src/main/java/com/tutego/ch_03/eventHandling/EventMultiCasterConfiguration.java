package com.tutego.ch_03.eventHandling;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.support.TaskUtils;


@Configuration
public class EventMultiCasterConfiguration {

    @Bean /* name of the bean actually matters!!! */
    public ApplicationEventMulticaster applicationEventMulticaster() {
        var multicaster = new SimpleApplicationEventMulticaster();
        // with this multicaster all event handlers are being called asynchronously by default, without using the @Async
        multicaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
        multicaster.setErrorHandler(TaskUtils.LOG_AND_PROPAGATE_ERROR_HANDLER);
        return multicaster;
    }
}
