package by.academy.pharmacy.controller.command.impl;

import by.academy.pharmacy.controller.command.Command;
import jakarta.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.JSP_COMMON_LOGIN_JSP;
import static by.academy.pharmacy.entity.Constant.PREVIOUS_REQUEST_LINK;

public final class GetLoginFormCommand implements Command {

    @Override
    public String execute(final HttpServletRequest request) {
        request.setAttribute(PREVIOUS_REQUEST_LINK, request.getParameter(PREVIOUS_REQUEST_LINK));
        return JSP_COMMON_LOGIN_JSP;
    }
}
