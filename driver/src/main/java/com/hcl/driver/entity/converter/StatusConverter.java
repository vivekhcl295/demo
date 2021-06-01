package com.hcl.driver.entity.converter;

import com.hcl.driver.entity.Status;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, String> {


    @Override
    public String convertToDatabaseColumn(Status attribute) {
        return attribute.toString();
    }

    @Override
    public Status convertToEntityAttribute(String dbData) {
        return Status.fromValue(dbData);
    }
}
