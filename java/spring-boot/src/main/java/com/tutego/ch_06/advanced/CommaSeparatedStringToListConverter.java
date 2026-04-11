package com.tutego.ch_06.advanced;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Converter(autoApply = true) // applies the converter globally to all lists of strings, can also be set per attribute or referenced similarly to a @NamedQuery
public class CommaSeparatedStringToListConverter implements AttributeConverter<List<String>, String> {
    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        return attribute == null || attribute.isEmpty() ? "" : String.join(",", attribute);
    }

    @Override
    public List<String> convertToEntityAttribute(String column) {
        if (column == null || column.isBlank()) return new ArrayList<>();
        return new ArrayList<>(Arrays.asList(column.split(",")));
    }
}
