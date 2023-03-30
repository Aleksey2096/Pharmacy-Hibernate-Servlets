package by.academy.pharmacy.controller.command.impl;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.entity.SessionUser;
import by.academy.pharmacy.service.database.UserDaoService;
import by.academy.pharmacy.service.database.impl.UserDaoServiceImpl;
import by.academy.pharmacy.service.util.SessionUserUtil;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.ERROR_LOGIN_PASS_MESSAGE_KEY;
import static by.academy.pharmacy.entity.Constant.JSP_COMMON_LOGIN_JSP;
import static by.academy.pharmacy.entity.Constant.LOGIN;
import static by.academy.pharmacy.entity.Constant.PASSWORD;
import static by.academy.pharmacy.entity.Constant.PREVIOUS_REQUEST_LINK;
import static by.academy.pharmacy.entity.Constant.TEXT_LOGIN_ERROR;
import static by.academy.pharmacy.entity.Constant.USER;

public final class LoginCommand implements Command {
    private final UserDaoService service = new UserDaoServiceImpl();

    @Override
    public String execute(final HttpServletRequest request) {
        String page;
        UserDTO userDTO = service.login(request.getParameter(LOGIN),
                request.getParameter(PASSWORD));
        if (userDTO != null) {
            SessionUser sessionUser = SessionUserUtil.convertToSessionUser(
                    userDTO);
            request.getSession().setAttribute(USER, sessionUser);
            page = request.getParameter(PREVIOUS_REQUEST_LINK);
        } else {
            request.setAttribute(PREVIOUS_REQUEST_LINK,
                    request.getParameter(PREVIOUS_REQUEST_LINK));
            page = JSP_COMMON_LOGIN_JSP;
            request.setAttribute(ERROR_LOGIN_PASS_MESSAGE_KEY,
                    TEXT_LOGIN_ERROR);
        }
        return page;
    }
}
