package by.academy.pharmacy.controller.command.impl.producer;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.entity.Country;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.COUNTRIES;
import static by.academy.pharmacy.entity.Constant.JSP_PHARMACIST_PRODUCERS_NEW_JSP;
import static by.academy.pharmacy.entity.Constant.PREVIOUS_REQUEST_LINK;

public final class GetProducerCreateFormCommand implements Command {
    @Override
    public String execute(final HttpServletRequest request) {
        request.setAttribute(PREVIOUS_REQUEST_LINK,
                request.getParameter(PREVIOUS_REQUEST_LINK));
        request.setAttribute(COUNTRIES, Country.values());
        return JSP_PHARMACIST_PRODUCERS_NEW_JSP;
    }
}
