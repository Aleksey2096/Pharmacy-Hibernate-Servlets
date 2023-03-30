package by.academy.pharmacy.controller.command.impl.prescriptionRequest;

import by.academy.pharmacy.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.JSP_CLIENT_PRESCRIPTION_REQUESTS_NEW_JSP;
import static by.academy.pharmacy.entity.Constant.PREVIOUS_REQUEST_LINK;

public final class GetPrescriptionRequestCreateFormCommand implements Command {
    @Override
    public String execute(final HttpServletRequest request) {
        request.setAttribute(PREVIOUS_REQUEST_LINK,
                request.getParameter(PREVIOUS_REQUEST_LINK));
        return JSP_CLIENT_PRESCRIPTION_REQUESTS_NEW_JSP;
    }
}
