package by.academy.pharmacy.service.mapping.impl;

import by.academy.pharmacy.dto.AddressDTO;
import by.academy.pharmacy.entity.AddressEntity;
import by.academy.pharmacy.service.mapping.Converter;

public final class AddressConverter
        implements Converter<AddressEntity, AddressDTO> {
    @Override
    public AddressDTO convertToDto(final AddressEntity entity) {
        if (entity == null) {
            return null;
        }
        return AddressDTO.builder()
                .healthCareCardNumber(entity.getHealthCareCardNumber())
                .postcode(entity.getPostcode())
                .city(entity.getCity())
                .street(entity.getStreet())
                .house(entity.getHouse())
                .apartment(entity.getApartment())
                .build();
    }

    @Override
    public AddressEntity convertToEntity(final AddressDTO dto) {
        if (dto == null) {
            return null;
        }
        return AddressEntity.builder()
                .healthCareCardNumber(dto.getHealthCareCardNumber())
                .postcode(dto.getPostcode())
                .city(dto.getCity())
                .street(dto.getStreet())
                .house(dto.getHouse())
                .apartment(dto.getApartment())
                .build();
    }
}
