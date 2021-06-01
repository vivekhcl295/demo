package com.hcl.restaurant.entity.converter;

import com.hcl.restaurant.entity.RestaurantType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class RestaurantTypeConverter implements AttributeConverter<RestaurantType, String> {
    @Override
    public String convertToDatabaseColumn(RestaurantType attribute) {
        return attribute.toString();
    }

    @Override
    public RestaurantType convertToEntityAttribute(String dbData) {
        return RestaurantType.fromValue(dbData);
    }
}
