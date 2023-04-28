package by.academy.pharmacy.service.util;

import by.academy.pharmacy.entity.Country;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public final class CountryConverter implements AttributeConverter<Country, String> {

    @Override
    public String convertToDatabaseColumn(final Country attribute) {
        return attribute.getCode();
    }

    @Override
    public Country convertToEntityAttribute(final String dbData) {
        return Country.valueOfCode(dbData);
    }
}
