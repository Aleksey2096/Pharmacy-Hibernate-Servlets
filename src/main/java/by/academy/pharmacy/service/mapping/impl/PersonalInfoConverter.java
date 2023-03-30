package by.academy.pharmacy.service.mapping.impl;

import by.academy.pharmacy.dto.AddressDTO;
import by.academy.pharmacy.dto.PersonalInfoDTO;
import by.academy.pharmacy.entity.AddressEntity;
import by.academy.pharmacy.entity.PersonalInfoEntity;
import by.academy.pharmacy.service.mapping.Converter;

public final class PersonalInfoConverter
        implements Converter<PersonalInfoEntity, PersonalInfoDTO> {
    private final Converter<AddressEntity, AddressDTO> addressConverter
            = new AddressConverter();

    @Override
    public PersonalInfoDTO convertToDto(final PersonalInfoEntity entity) {
        if (entity == null) {
            return null;
        }
        return PersonalInfoDTO.builder()
                .healthCareCardNumber(entity.getHealthCareCardNumber())
                .surname(entity.getSurname())
                .name(entity.getName())
                .birthDate(entity.getBirthDate())
                .addressDTO(addressConverter.convertToDto(
                        entity.getAddressEntity()))
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .position(entity.getPosition())
                .personalAccount(entity.getPersonalAccount())
                .paymentCardNumber(entity.getPaymentCardNumber())
                .build();
    }

    @Override
    public PersonalInfoEntity convertToEntity(final PersonalInfoDTO dto) {
        if (dto == null) {
            return null;
        }
        return PersonalInfoEntity.builder()
                .healthCareCardNumber(dto.getHealthCareCardNumber())
                .surname(dto.getSurname())
                .name(dto.getName())
                .birthDate(dto.getBirthDate())
                .addressEntity(
                        addressConverter.convertToEntity(dto.getAddressDTO()))
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .position(dto.getPosition())
                .personalAccount(dto.getPersonalAccount())
                .paymentCardNumber(dto.getPaymentCardNumber())
                .build();
    }
}
