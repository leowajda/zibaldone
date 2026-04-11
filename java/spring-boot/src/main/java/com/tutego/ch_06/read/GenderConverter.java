package com.tutego.ch_06.read;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class GenderConverter implements AttributeConverter<Gender, Byte> {
    @Override
    public Byte convertToDatabaseColumn(Gender gender) {
        return switch (gender) {
            case FEMALE -> 1;
            case MALE -> 2;
        };
    }

    @Override
    public Gender convertToEntityAttribute(Byte gender) {
        return switch (gender) {
            case 1 -> Gender.FEMALE;
            case 2 -> Gender.MALE;
            default -> throw new IllegalStateException("Unexpected value: " + gender);
        };
    }
}