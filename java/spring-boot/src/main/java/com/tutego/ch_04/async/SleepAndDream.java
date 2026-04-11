package com.tutego.ch_04.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Component
public class SleepAndDream {

    private static final Logger logger = LoggerFactory.getLogger(SleepAndDream.class);

    @Async // the proxy 'hides' the side effect of CompletableFuture<Void> but makes it much harder to trace
    public void sleepAsyncVoid() throws Exception {
        logger.info("Going to sleep: SNNNNOOORRRREEEEE");
        TimeUnit.SECONDS.sleep(1);
        logger.info("Woke up");
    }

    @Async
    public CompletableFuture<String> sleepAsyncString() throws Exception {
        logger.info("Starting to dream");
        TimeUnit.SECONDS.sleep(1);
        logger.info("Finished the dream");
        return CompletableFuture.completedFuture("about unicorns");
    }
}

