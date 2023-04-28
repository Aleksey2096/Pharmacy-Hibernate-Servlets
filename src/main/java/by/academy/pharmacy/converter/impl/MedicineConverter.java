package by.academy.pharmacy.converter.impl;

import by.academy.pharmacy.converter.Converter;
import by.academy.pharmacy.dto.MedicineDTO;
import by.academy.pharmacy.dto.ProducerDTO;
import by.academy.pharmacy.entity.MedicineEntity;
import by.academy.pharmacy.entity.ProducerEntity;

public final class MedicineConverter implements Converter<MedicineEntity, MedicineDTO> {
    private final Converter<ProducerEntity, ProducerDTO> producerConverter
            = new ProducerConverter();

    @Override
    public MedicineDTO convertToDto(final MedicineEntity entity) {
        if (entity == null) {
            return null;
        }
        return MedicineDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .isNonprescription(entity.getIsNonprescription())
                .producerDTO(producerConverter.convertToDto(entity.getProducerEntity()))
                .approvalDate(entity.getApprovalDate())
                .medicineImagePath(entity.getMedicineImagePath())
                .build();
    }

    @Override
    public MedicineEntity convertToEntity(final MedicineDTO dto) {
        if (dto == null) {
            return null;
        }
        return MedicineEntity.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .isNonprescription(dto.getIsNonprescription())
                .producerEntity(producerConverter.convertToEntity(dto.getProducerDTO()))
                .approvalDate(dto.getApprovalDate())
                .medicineImagePath(dto.getMedicineImagePath())
                .build();
    }
}
