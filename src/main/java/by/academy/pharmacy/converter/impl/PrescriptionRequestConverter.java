package by.academy.pharmacy.converter.impl;

import by.academy.pharmacy.converter.Converter;
import by.academy.pharmacy.dto.PrescriptionRequestDTO;
import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.entity.PrescriptionRequestEntity;
import by.academy.pharmacy.entity.UserEntity;

public final class PrescriptionRequestConverter
        implements Converter<PrescriptionRequestEntity, PrescriptionRequestDTO> {
    private final Converter<UserEntity, UserDTO> userConverter = new UserConverter();

    @Override
    public PrescriptionRequestDTO convertToDto(final PrescriptionRequestEntity entity) {
        if (entity == null) {
            return null;
        }
        return PrescriptionRequestDTO.builder()
                .id(entity.getId())
                .prescriptionScanPath(entity.getPrescriptionScanPath())
                .uploadDateTime(entity.getUploadDateTime())
                .prescriptionRequestStatus(entity.getPrescriptionRequestStatus())
                .userDTO(userConverter.convertToDto(entity.getUserEntity()))
                .build();
    }

    @Override
    public PrescriptionRequestEntity convertToEntity(final PrescriptionRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return PrescriptionRequestEntity.builder()
                .id(dto.getId())
                .prescriptionScanPath(dto.getPrescriptionScanPath())
                .uploadDateTime(dto.getUploadDateTime())
                .prescriptionRequestStatus(dto.getPrescriptionRequestStatus())
                .userEntity(userConverter.convertToEntity(dto.getUserDTO()))
                .build();
    }
}
