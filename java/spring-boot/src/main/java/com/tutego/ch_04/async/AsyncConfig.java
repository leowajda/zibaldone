package com.tutego.ch_04.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.stream.IntStream;

// TaskExecutor is the Spring equivalent of the Executor from the std (it predates it and is configurable at runtime)
// public interface TaskExecutor extends Executor
@Configuration
class AsyncConfig implements AsyncConfigurer {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (throwable, method, params) -> {
            log.info("Exception: {}", throwable.getMessage());
            log.info("Method: {}", method);
            IntStream.range(0, params.length).forEach(index -> log.info("Parameter {}: {}", index, params[index]));
        };
    }
}
