package by.academy.pharmacy.controller.extractor.impl;

import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.dto.ProducerDTO;
import by.academy.pharmacy.service.util.RequestDataUtil;
import jakarta.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.COMPANY_NAME;
import static by.academy.pharmacy.entity.Constant.COUNTRY;
import static by.academy.pharmacy.entity.Constant.CREATION_DATE;
import static by.academy.pharmacy.entity.Constant.PRODUCER_ID_DB;

public final class ProducerDtoExtractor implements Extractor<ProducerDTO> {
    @Override
    public ProducerDTO extract(final HttpServletRequest request) {
        return ProducerDTO.builder()
                .id(RequestDataUtil.getLong(PRODUCER_ID_DB, request))
                .companyName(RequestDataUtil.getString(COMPANY_NAME, request))
                .country(RequestDataUtil.getCountry(COUNTRY, request))
                .creationDate(RequestDataUtil.getDate(CREATION_DATE, request))
                .build();
    }
}
