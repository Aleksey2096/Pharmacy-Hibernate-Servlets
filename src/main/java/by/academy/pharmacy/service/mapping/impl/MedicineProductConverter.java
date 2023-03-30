package by.academy.pharmacy.service.mapping.impl;

import by.academy.pharmacy.dto.MedicineDTO;
import by.academy.pharmacy.dto.MedicineProductDTO;
import by.academy.pharmacy.entity.MedicineEntity;
import by.academy.pharmacy.entity.MedicineProductEntity;
import by.academy.pharmacy.service.mapping.Converter;

public final class MedicineProductConverter
        implements Converter<MedicineProductEntity, MedicineProductDTO> {
    private final Converter<MedicineEntity, MedicineDTO> medicineConverter
            = new MedicineConverter();

    @Override
    public MedicineProductDTO convertToDto(final MedicineProductEntity entity) {
        if (entity == null) {
            return null;
        }
        return MedicineProductDTO.builder()
                .id(entity.getId())
                .medicineDTO(medicineConverter.convertToDto(
                        entity.getMedicineEntity()))
                .dosage(entity.getDosage())
                .form(entity.getForm())
                .price(entity.getPrice())
                .amount(entity.getAmount())
                .build();
    }

    @Override
    public MedicineProductEntity convertToEntity(final MedicineProductDTO dto) {
        if (dto == null) {
            return null;
        }
        return MedicineProductEntity.builder()
                .id(dto.getId())
                .medicineEntity(
                        medicineConverter.convertToEntity(dto.getMedicineDTO()))
                .dosage(dto.getDosage())
                .form(dto.getForm())
                .price(dto.getPrice())
                .amount(dto.getAmount())
                .build();
    }
}
