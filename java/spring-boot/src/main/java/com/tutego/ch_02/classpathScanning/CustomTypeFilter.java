package com.tutego.ch_02.classpathScanning;

import java.io.IOException;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class CustomTypeFilter implements TypeFilter {

  @Override
  public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
    ClassMetadata classMetadata = metadataReader.getClassMetadata();
    return classMetadata.hasEnclosingClass() && classMetadata.isFinal();
  }

  static final class InnerFinalClass {}

}
