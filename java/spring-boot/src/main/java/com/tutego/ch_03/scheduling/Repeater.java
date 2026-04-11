package com.tutego.ch_03.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Repeater {

    private static final Logger logger = LoggerFactory.getLogger(Repeater.class);

    // The method annotated with @Scheduled must not have a parameter list.
    // Spring calls the method and passes nothing to the method; auto-wiring of parameters is also not possible.
    // The method doesn’t return anything because there’s nowhere for the results to go (side effects only).
    @Scheduled(
            timeUnit = TimeUnit.SECONDS, // defaults to milliseconds
            initialDelay = 5,
            fixedDelay = 1,
            fixedRate = -1L // different from `fixedDelay` if the side effect takes longer than the `fixedDelay` to run
    )
    public void helloWorld() {
        logger.info("hello world");
    }

    // @daily / @midnight / @weekly / @monthly / @yearly macro syntax for expression Linux CronJobs
    @Scheduled(cron = "@hourly")
    public void cronMacro() {}

}
