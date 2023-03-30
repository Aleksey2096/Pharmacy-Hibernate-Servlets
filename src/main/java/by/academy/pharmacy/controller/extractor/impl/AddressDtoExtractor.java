package by.academy.pharmacy.controller.extractor.impl;

import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.dto.AddressDTO;
import by.academy.pharmacy.service.util.RequestDataUtil;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.APARTMENT;
import static by.academy.pharmacy.entity.Constant.CITY;
import static by.academy.pharmacy.entity.Constant.HEALTH_CARE_CARD_NUMBER_DB;
import static by.academy.pharmacy.entity.Constant.HOUSE;
import static by.academy.pharmacy.entity.Constant.POSTCODE;
import static by.academy.pharmacy.entity.Constant.STREET;

public final class AddressDtoExtractor implements Extractor<AddressDTO> {
    @Override
    public AddressDTO extract(final HttpServletRequest request) {
        return AddressDTO.builder()
                .healthCareCardNumber(
                        RequestDataUtil.getLong(HEALTH_CARE_CARD_NUMBER_DB,
                                request))
                .postcode(RequestDataUtil.getInteger(POSTCODE, request))
                .city(RequestDataUtil.getString(CITY, request))
                .street(RequestDataUtil.getString(STREET, request))
                .house(RequestDataUtil.getInteger(HOUSE, request))
                .apartment(RequestDataUtil.getInteger(APARTMENT, request))
                .build();
    }
}
