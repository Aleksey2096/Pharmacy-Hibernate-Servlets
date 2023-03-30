package by.academy.pharmacy.controller.command.impl.prescriptionRequest;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.controller.extractor.impl.OrderObjectExtractor;
import by.academy.pharmacy.controller.extractor.impl.PaginationObjectExtractor;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.entity.PrescriptionRequestEntity;
import by.academy.pharmacy.service.database.PrescriptionRequestDaoService;
import by.academy.pharmacy.service.database.impl.PrescriptionRequestDaoServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.COMMAND;
import static by.academy.pharmacy.entity.Constant.JSP_PHARMACIST_PRESCRIPTION_REQUESTS_INDEX_JSP;
import static by.academy.pharmacy.entity.Constant.ORDER_OBJECT;
import static by.academy.pharmacy.entity.Constant.PRESCRIPTION_REQUESTS;
import static by.academy.pharmacy.entity.Constant.SEARCH_VALUE;

public final class ProcessPaginatedPrescriptionRequestsCommand
        implements Command {
    /**
     * service working with dao layer.
     */
    private final PrescriptionRequestDaoService service
            = new PrescriptionRequestDaoServiceImpl();
    /**
     * extracts PaginationObject from request.
     */
    private final Extractor<PaginationObject<PrescriptionRequestEntity>>
            paginationObjectExtractor = new PaginationObjectExtractor<>();
    /**
     * extracts OrderObject from request.
     */
    private final Extractor<OrderObject> orderObjectExtractor
            = new OrderObjectExtractor();

    @Override
    public String execute(final HttpServletRequest request) {
        request.setAttribute(COMMAND, request.getParameter(COMMAND));
        PaginationObject<PrescriptionRequestEntity> paginationObject
                = paginationObjectExtractor
                .extract(request);
        OrderObject orderObject = orderObjectExtractor.extract(request);
        String searchValue = request.getParameter(SEARCH_VALUE);
        request.setAttribute(SEARCH_VALUE, searchValue);
        request.setAttribute(ORDER_OBJECT, orderObject);
        request.setAttribute(PRESCRIPTION_REQUESTS, service
                .readAllUnprocessedWithParameters(paginationObject, orderObject,
                        searchValue));
        return JSP_PHARMACIST_PRESCRIPTION_REQUESTS_INDEX_JSP;
    }
}
