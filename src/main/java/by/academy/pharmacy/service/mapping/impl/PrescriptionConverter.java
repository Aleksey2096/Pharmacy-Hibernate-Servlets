package by.academy.pharmacy.service.mapping.impl;

import by.academy.pharmacy.dto.MedicineProductDTO;
import by.academy.pharmacy.dto.PrescriptionDTO;
import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.entity.MedicineProductEntity;
import by.academy.pharmacy.entity.PrescriptionEntity;
import by.academy.pharmacy.entity.UserEntity;
import by.academy.pharmacy.service.mapping.Converter;

public final class PrescriptionConverter
        implements Converter<PrescriptionEntity, PrescriptionDTO> {
    private final Converter<UserEntity, UserDTO> userConverter
            = new UserConverter();
    private final Converter<MedicineProductEntity, MedicineProductDTO>
            medicineProductConverter = new MedicineProductConverter();

    @Override
    public PrescriptionDTO convertToDto(final PrescriptionEntity entity) {
        if (entity == null) {
            return null;
        }
        return PrescriptionDTO.builder()
                .id(entity.getId())
                .userDTO(userConverter.convertToDto(entity.getUserEntity()))
                .medicineProductDTO(medicineProductConverter.convertToDto(
                        entity.getMedicineProductEntity()))
                .amount(entity.getAmount())
                .date(entity.getDate())
                .build();
    }

    @Override
    public PrescriptionEntity convertToEntity(final PrescriptionDTO dto) {
        if (dto == null) {
            return null;
        }
        return PrescriptionEntity.builder()
                .id(dto.getId())
                .userEntity(userConverter.convertToEntity(dto.getUserDTO()))
                .medicineProductEntity(medicineProductConverter.convertToEntity(
                        dto.getMedicineProductDTO()))
                .amount(dto.getAmount())
                .date(dto.getDate())
                .build();
    }
}
