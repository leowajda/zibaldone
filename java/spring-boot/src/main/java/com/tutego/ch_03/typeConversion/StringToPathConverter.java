package com.tutego.ch_03.typeConversion;

import java.nio.file.Path;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

// see also GenericConverter and ConverterFactory
@Component
class StringToPathConverter implements Converter<String, Path> {

  @Override
  public Path convert(String source) {
    return Path.of(source);
  }

}
