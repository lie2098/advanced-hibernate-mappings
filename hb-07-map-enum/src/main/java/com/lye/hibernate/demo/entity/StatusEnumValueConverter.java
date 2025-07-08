package com.lye.hibernate.demo.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusEnumValueConverter implements AttributeConverter<StatusEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(StatusEnum statusEnum) {
        return  statusEnum != null ? statusEnum.getValue() : null;
    }

    @Override
    public StatusEnum convertToEntityAttribute(Integer value) {
        return value != null ? StatusEnum.fromValue(value) : null;
    }
}
