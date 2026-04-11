package com.tutego.ch_09.mappers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;

@Configuration
class YearMonthRangeFormatterConfig {

    @Bean // registers a formatter to be used by ConversionService
    public Formatter<YearMonthRange> yearMonthRangeFormatter() {
        return new YearMonthRangeFormatter();
    }

}
