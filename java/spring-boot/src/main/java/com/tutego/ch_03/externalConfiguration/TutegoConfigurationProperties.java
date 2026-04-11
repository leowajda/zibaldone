package com.tutego.ch_03.externalConfiguration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.boot.convert.PeriodUnit;
import org.springframework.util.unit.DataUnit;

import java.time.Duration;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

//@Component <- no need for this, alternatively a JavaBean can also be used
@ConfigurationProperties(value = "com.tutego", ignoreUnknownFields = false)
public record TutegoConfigurationProperties(
        String homepage,
        @DefaultValue("42") int numberOfSeminars,
        int[] portsToTest,
        TimeUnit repetitionUnit,
        List<Server> list,
        Map<String, Server> map,
        @DataSizeUnit(DataUnit.MEGABYTES) org.springframework.util.unit.DataSize maxFileSize /* models data size in terms of bytes */,
        @DurationUnit(ChronoUnit.SECONDS) Duration timeout /* defaults to milliseconds if unit is not explicit */,
        @PeriodUnit(ChronoUnit.DAYS) Period minInterval /* defaults to days if unit is not explicit */
) { }

record Server(String ip) {}