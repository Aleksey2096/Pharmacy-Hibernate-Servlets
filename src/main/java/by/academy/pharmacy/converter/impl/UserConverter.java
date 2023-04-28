package by.academy.pharmacy.converter.impl;

import by.academy.pharmacy.converter.Converter;
import by.academy.pharmacy.dto.MedicineProductDTO;
import by.academy.pharmacy.dto.PersonalInfoDTO;
import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.entity.MedicineProductEntity;
import by.academy.pharmacy.entity.PersonalInfoEntity;
import by.academy.pharmacy.entity.UserEntity;

public final class UserConverter implements Converter<UserEntity, UserDTO> {
    private final Converter<PersonalInfoEntity, PersonalInfoDTO> personalInfoConverter
            = new PersonalInfoConverter();
    private final Converter<MedicineProductEntity, MedicineProductDTO> medicineProductConverter
            = new MedicineProductConverter();

    @Override
    public UserDTO convertToDto(final UserEntity entity) {
        if (entity == null) {
            return null;
        }
        return UserDTO.builder()
                .healthCareCardNumber(entity.getHealthCareCardNumber())
                .login(entity.getLogin())
                .password(entity.getPassword())
                .role(entity.getRole())
                .joinedDate(entity.getJoinedDate())
                .personalInfoDTO(personalInfoConverter.convertToDto(entity.getPersonalInfoEntity()))
                .avatarImagePath(entity.getAvatarImagePath())
                .build();
    }

    @Override
    public UserEntity convertToEntity(final UserDTO dto) {
        if (dto == null) {
            return null;
        }
        return UserEntity.builder()
                .healthCareCardNumber(dto.getHealthCareCardNumber())
                .login(dto.getLogin())
                .password(dto.getPassword())
                .role(dto.getRole())
                .joinedDate(dto.getJoinedDate())
                .personalInfoEntity(personalInfoConverter.convertToEntity(dto.getPersonalInfoDTO()))
                .avatarImagePath(dto.getAvatarImagePath())
                .cart(medicineProductConverter.convertToEntities(dto.getCart()))
                .build();
    }
}
