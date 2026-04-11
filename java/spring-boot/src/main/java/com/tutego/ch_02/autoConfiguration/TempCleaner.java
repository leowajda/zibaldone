package com.tutego.ch_02.autoConfiguration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ConditionalOnLowDiskSpace
class TempCleaner {

    private final Logger log = LoggerFactory.getLogger(getClass());

    public TempCleaner() {
        log.info("Cleaning temp directory to acquire more free disk space");
    }
}