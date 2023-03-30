package by.academy.pharmacy.controller.extractor.impl;

import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.dto.MedicineProductDTO;
import by.academy.pharmacy.service.util.RequestDataUtil;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.AMOUNT;
import static by.academy.pharmacy.entity.Constant.DOSAGE;
import static by.academy.pharmacy.entity.Constant.FORM;
import static by.academy.pharmacy.entity.Constant.MEDICINE_PRODUCT_ID_DB;
import static by.academy.pharmacy.entity.Constant.PRICE;

public final class MedicineProductDtoExtractor
        implements Extractor<MedicineProductDTO> {

    @Override
    public MedicineProductDTO extract(final HttpServletRequest request) {
        return MedicineProductDTO.builder()
                .id(RequestDataUtil.getLong(MEDICINE_PRODUCT_ID_DB, request))
                .dosage(RequestDataUtil.getShort(DOSAGE, request))
                .form(RequestDataUtil.getForm(FORM, request))
                .price(RequestDataUtil.getBigDecimal(PRICE, request))
                .amount(RequestDataUtil.getInteger(AMOUNT, request)).build();
    }
}
