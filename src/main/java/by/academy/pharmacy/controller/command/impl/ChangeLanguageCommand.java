package by.academy.pharmacy.controller.command.impl;

import by.academy.pharmacy.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import static by.academy.pharmacy.entity.Constant.LOCALE;
import static by.academy.pharmacy.entity.Constant.PREVIOUS_REQUEST_LINK;

public final class ChangeLanguageCommand implements Command {

    @Override
    public String execute(final HttpServletRequest request) {
        String locale = request.getParameter(LOCALE);
        request.getSession().setAttribute(LOCALE, locale);
        return URLDecoder.decode(request.getParameter(PREVIOUS_REQUEST_LINK),
                StandardCharsets.UTF_8);
    }
}
