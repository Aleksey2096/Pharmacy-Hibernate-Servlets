package by.academy.pharmacy.service.util;

import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.entity.SessionUser;

public final class SessionUserUtil {
    private SessionUserUtil() {
    }

    public static SessionUser convertToSessionUser(final UserDTO userDTO) {
        SessionUser sessionUser = new SessionUser();
        sessionUser.setHealthCareCardNumber(userDTO.getHealthCareCardNumber());
        sessionUser.setLogin(userDTO.getLogin());
        sessionUser.setRole(userDTO.getRole());
        return sessionUser;
    }
}
