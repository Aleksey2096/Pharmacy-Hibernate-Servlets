package by.academy.pharmacy.converter.impl;

import by.academy.pharmacy.converter.Converter;
import by.academy.pharmacy.dto.ProducerDTO;
import by.academy.pharmacy.entity.ProducerEntity;

public final class ProducerConverter implements Converter<ProducerEntity, ProducerDTO> {
    @Override
    public ProducerDTO convertToDto(final ProducerEntity entity) {
        if (entity == null) {
            return null;
        }
        return ProducerDTO.builder()
                .id(entity.getId())
                .companyName(entity.getCompanyName())
                .country(entity.getCountry())
                .creationDate(entity.getCreationDate())
                .build();
    }

    @Override
    public ProducerEntity convertToEntity(final ProducerDTO dto) {
        if (dto == null) {
            return null;
        }
        return ProducerEntity.builder()
                .id(dto.getId())
                .companyName(dto.getCompanyName())
                .country(dto.getCountry())
                .creationDate(dto.getCreationDate())
                .build();
    }
}
