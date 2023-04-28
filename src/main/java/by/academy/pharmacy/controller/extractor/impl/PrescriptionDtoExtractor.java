package by.academy.pharmacy.controller.extractor.impl;

import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.dto.PrescriptionDTO;
import by.academy.pharmacy.service.util.RequestDataUtil;
import jakarta.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.AMOUNT;
import static by.academy.pharmacy.entity.Constant.DATE;
import static by.academy.pharmacy.entity.Constant.PRESCRIPTION_ID_DB;

public final class PrescriptionDtoExtractor implements Extractor<PrescriptionDTO> {
    @Override
    public PrescriptionDTO extract(final HttpServletRequest request) {
        return PrescriptionDTO.builder()
                .id(RequestDataUtil.getLong(PRESCRIPTION_ID_DB, request))
                .amount(RequestDataUtil.getInteger(AMOUNT, request))
                .date(RequestDataUtil.getDate(DATE, request))
                .build();
    }
}
