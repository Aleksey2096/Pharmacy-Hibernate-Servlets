package by.academy.pharmacy.service.util;

import by.academy.pharmacy.entity.Form;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public final class FormConverter implements AttributeConverter<Form, String> {

    @Override
    public String convertToDatabaseColumn(final Form attribute) {
        return attribute.toString().toLowerCase();
    }

    @Override
    public Form convertToEntityAttribute(final String dbData) {
        return Form.valueOf(dbData.toUpperCase());
    }

}
