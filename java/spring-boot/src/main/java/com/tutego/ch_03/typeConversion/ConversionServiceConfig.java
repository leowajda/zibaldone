package com.tutego.ch_03.typeConversion;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

@Configuration
public class ConversionServiceConfig {

    @Bean
    @ConditionalOnMissingBean /* not always injected depends on the classpath */
    public ConversionService conversionService() {
        return ApplicationConversionService.getSharedInstance();
    }

}
