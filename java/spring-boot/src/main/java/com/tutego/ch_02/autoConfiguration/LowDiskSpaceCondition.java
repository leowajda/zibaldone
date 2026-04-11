package com.tutego.ch_02.autoConfiguration;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.unit.DataSize;

import java.io.File;

public class LowDiskSpaceCondition implements Condition {

    @Override
    public boolean matches(ConditionContext ctx, AnnotatedTypeMetadata metadata) {
        return DataSize.ofBytes(new File("/").getFreeSpace()).toGigabytes() < 10;
    }

}
