package by.academy.pharmacy.controller.command.impl.prescription;

import by.academy.pharmacy.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.JSP_PHARMACIST_PRESCRIPTIONS_NEW_JSP;
import static by.academy.pharmacy.entity.Constant.PRESCRIPTION_REQUEST_ID_DB;
import static by.academy.pharmacy.entity.Constant.PREVIOUS_REQUEST_LINK;
import static by.academy.pharmacy.entity.Constant.PREVIOUS_REQUEST_LINK_APPROVED;

public final class GetPrescriptionCreateFormCommand implements Command {
    @Override
    public String execute(final HttpServletRequest request) {
        request.setAttribute(PREVIOUS_REQUEST_LINK,
                request.getParameter(PREVIOUS_REQUEST_LINK));
        request.setAttribute(PREVIOUS_REQUEST_LINK_APPROVED,
                request.getParameter(PREVIOUS_REQUEST_LINK_APPROVED));
        request.setAttribute(PRESCRIPTION_REQUEST_ID_DB,
                request.getParameter(PRESCRIPTION_REQUEST_ID_DB));
        return JSP_PHARMACIST_PRESCRIPTIONS_NEW_JSP;
    }
}
