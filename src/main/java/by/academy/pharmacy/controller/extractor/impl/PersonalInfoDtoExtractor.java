package by.academy.pharmacy.controller.extractor.impl;

import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.dto.PersonalInfoDTO;
import by.academy.pharmacy.service.util.RequestDataUtil;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.DATE_OF_BIRTH_DB;
import static by.academy.pharmacy.entity.Constant.EMAIL;
import static by.academy.pharmacy.entity.Constant.HEALTH_CARE_CARD_NUMBER_DB;
import static by.academy.pharmacy.entity.Constant.NAME;
import static by.academy.pharmacy.entity.Constant.PAYMENT_CARD_NUMBER_DB;
import static by.academy.pharmacy.entity.Constant.PERSONAL_ACCOUNT_DB;
import static by.academy.pharmacy.entity.Constant.PHONE;
import static by.academy.pharmacy.entity.Constant.POSITION;
import static by.academy.pharmacy.entity.Constant.SURNAME;

public final class PersonalInfoDtoExtractor
        implements Extractor<PersonalInfoDTO> {
    @Override
    public PersonalInfoDTO extract(final HttpServletRequest request) {
        return PersonalInfoDTO.builder()
                .healthCareCardNumber(
                        RequestDataUtil.getLong(HEALTH_CARE_CARD_NUMBER_DB,
                                request))
                .surname(RequestDataUtil.getString(SURNAME, request))
                .name(RequestDataUtil.getString(NAME, request))
                .birthDate(RequestDataUtil.getDate(DATE_OF_BIRTH_DB, request))
                .phone(RequestDataUtil.getString(PHONE, request))
                .email(RequestDataUtil.getString(EMAIL, request))
                .position(RequestDataUtil.getString(POSITION, request))
                .personalAccount(
                        RequestDataUtil.getBigDecimal(PERSONAL_ACCOUNT_DB,
                                request))
                .paymentCardNumber(
                        RequestDataUtil.getLong(PAYMENT_CARD_NUMBER_DB,
                                request))
                .build();
    }
}
