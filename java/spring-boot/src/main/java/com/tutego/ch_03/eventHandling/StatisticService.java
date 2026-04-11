package com.tutego.ch_03.eventHandling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class StatisticService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Async // by default event buses block until all consumers are done (@Async breaks event transform and exception handling)
    @Order(100) // if there are multiple consumers for a given event, consumption can be ordered
    @EventListener(condition = "#event.name != 'test'")
    public NewPhotoEvent onNewPhotoEvent(NewPhotoEvent event) {
        log.info("New photo: {}", event);
        return event; // might return one or many events which get automatically pushed through the event bus
    }

}
