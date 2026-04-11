package com.tutego.ch_03.typeConversion;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.nio.file.Path;

// see also GenericConverter and ConverterFactory
@Component
class StringToPathConverter implements Converter<String, Path> {

    @Override
    public Path convert(String source) {
        return Path.of(source);
    }
}
