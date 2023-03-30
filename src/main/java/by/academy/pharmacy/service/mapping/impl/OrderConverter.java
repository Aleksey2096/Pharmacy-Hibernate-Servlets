package by.academy.pharmacy.service.mapping.impl;

import by.academy.pharmacy.dto.MedicineProductDTO;
import by.academy.pharmacy.dto.OrderDTO;
import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.entity.MedicineProductEntity;
import by.academy.pharmacy.entity.OrderEntity;
import by.academy.pharmacy.entity.UserEntity;
import by.academy.pharmacy.service.mapping.Converter;

public final class OrderConverter implements Converter<OrderEntity, OrderDTO> {
    private final Converter<UserEntity, UserDTO> userConverter
            = new UserConverter();
    private final Converter<MedicineProductEntity, MedicineProductDTO>
            medicineProductConverter = new MedicineProductConverter();

    @Override
    public OrderDTO convertToDto(final OrderEntity entity) {
        if (entity == null) {
            return null;
        }
        return OrderDTO.builder()
                .id(entity.getId())
                .localDateTime(entity.getLocalDateTime())
                .userDTO(userConverter.convertToDto(entity.getUserEntity()))
                .medicineProductDTO(medicineProductConverter.convertToDto(
                        entity.getMedicineProductEntity()))
                .amount(entity.getAmount())
                .price(entity.getPrice())
                .paymentCardNumber(entity.getPaymentCardNumber())
                .contactPhone(entity.getContactPhone())
                .deliveryAddress(entity.getDeliveryAddress())
                .build();
    }

    @Override
    public OrderEntity convertToEntity(final OrderDTO dto) {
        if (dto == null) {
            return null;
        }
        return OrderEntity.builder()
                .id(dto.getId())
                .localDateTime(dto.getLocalDateTime())
                .userEntity(userConverter.convertToEntity(dto.getUserDTO()))
                .medicineProductEntity(medicineProductConverter.convertToEntity(
                        dto.getMedicineProductDTO()))
                .amount(dto.getAmount())
                .price(dto.getPrice())
                .paymentCardNumber(dto.getPaymentCardNumber())
                .contactPhone(dto.getContactPhone())
                .deliveryAddress(dto.getDeliveryAddress())
                .build();
    }
}
