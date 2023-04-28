package by.academy.pharmacy.controller.extractor.impl;

import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.dto.MedicineProductDTO;
import by.academy.pharmacy.dto.OrderDTO;
import by.academy.pharmacy.service.util.RequestDataUtil;
import jakarta.servlet.http.HttpServletRequest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static by.academy.pharmacy.entity.Constant.CONTACT_PHONE_DB;
import static by.academy.pharmacy.entity.Constant.DELIVERY_ADDRESS_DB;
import static by.academy.pharmacy.entity.Constant.PAYMENT_CARD_NUMBER_DB;
import static by.academy.pharmacy.entity.Constant.PRODUCT;
import static by.academy.pharmacy.entity.Constant.SPACE;

public final class OrderDtoListExtractor implements Extractor<List<OrderDTO>> {
    @Override
    public List<OrderDTO> extract(final HttpServletRequest request) {
        Long paymentCardNumber = RequestDataUtil.getLong(PAYMENT_CARD_NUMBER_DB, request);
        String contactPhone = RequestDataUtil.getString(CONTACT_PHONE_DB, request);
        String deliveryAddress = RequestDataUtil.getString(DELIVERY_ADDRESS_DB, request);
        LocalDateTime localDateTime = LocalDateTime.now();
        List<OrderDTO> orderDTOs = new ArrayList<>();
        String[] products = request.getParameterValues(PRODUCT);
        for (final String newProduct : products) {
            OrderDTO orderDTO = new OrderDTO();
            String[] productArray = newProduct.split(SPACE);
            MedicineProductDTO medicineProductDTO = new MedicineProductDTO();
            medicineProductDTO.setId(Long.parseLong(productArray[0]));
            orderDTO.setMedicineProductDTO(medicineProductDTO);
            orderDTO.setPrice(new BigDecimal(productArray[1]));
            orderDTO.setAmount(Integer.parseInt(productArray[2]));
            orderDTO.setLocalDateTime(localDateTime);
            orderDTO.setPaymentCardNumber(paymentCardNumber);
            orderDTO.setContactPhone(contactPhone);
            orderDTO.setDeliveryAddress(deliveryAddress);
            orderDTOs.add(orderDTO);
        }
        return orderDTOs;
    }
}
