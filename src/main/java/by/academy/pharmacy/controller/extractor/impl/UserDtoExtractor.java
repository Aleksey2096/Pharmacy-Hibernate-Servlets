package by.academy.pharmacy.controller.extractor.impl;

import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.service.util.PasswordUtil;
import by.academy.pharmacy.service.util.RequestDataUtil;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Objects;

import static by.academy.pharmacy.entity.Constant.DATE_JOINED_DB;
import static by.academy.pharmacy.entity.Constant.EMPTY_PATH;
import static by.academy.pharmacy.entity.Constant.HEALTH_CARE_CARD_NUMBER_DB;
import static by.academy.pharmacy.entity.Constant.IMAGE;
import static by.academy.pharmacy.entity.Constant.IMG_USER;
import static by.academy.pharmacy.entity.Constant.JPG;
import static by.academy.pharmacy.entity.Constant.LOGIN;
import static by.academy.pharmacy.entity.Constant.PASSWORD;
import static by.academy.pharmacy.entity.Constant.ROLE;

public final class UserDtoExtractor implements Extractor<UserDTO> {
    @Override
    public UserDTO extract(final HttpServletRequest request) {
        UserDTO userDTO = UserDTO.builder()
                .healthCareCardNumber(RequestDataUtil.getLong(HEALTH_CARE_CARD_NUMBER_DB, request))
                .login(RequestDataUtil.getString(LOGIN, request))
                .password(PasswordUtil.generateStrongPasswordHash(
                        Objects.requireNonNull(RequestDataUtil.getString(PASSWORD, request))))
                .role(RequestDataUtil.getRole(ROLE, request))
                .joinedDate(RequestDataUtil.getDate(DATE_JOINED_DB, request))
                .build();
        String avatarImagePath = IMG_USER + userDTO.getHealthCareCardNumber() + JPG;
        userDTO.setAvatarImagePath(avatarImagePath);
        RequestDataUtil.saveFile(
                request.getServletContext().getRealPath(EMPTY_PATH) + avatarImagePath, request,
                IMAGE);
        return userDTO;
    }
}
