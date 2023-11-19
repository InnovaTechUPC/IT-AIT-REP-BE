package com.assignit.coreservice.shared.parse;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class BooleanToStringConverter implements AttributeConverter<Boolean, String> {
    public BooleanToStringConverter() {
    }

    public String convertToDatabaseColumn(Boolean value) {
        return value != null && value ? "Y" : "N";
    }

    public Boolean convertToEntityAttribute(String value) {
        return "Y".equals(value);
    }
}