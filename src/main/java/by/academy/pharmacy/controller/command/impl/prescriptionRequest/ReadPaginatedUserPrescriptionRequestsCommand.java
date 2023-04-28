package by.academy.pharmacy.controller.command.impl.prescriptionRequest;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.controller.extractor.impl.OrderObjectExtractor;
import by.academy.pharmacy.controller.extractor.impl.PaginationObjectExtractor;
import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.entity.PrescriptionRequestEntity;
import by.academy.pharmacy.entity.SessionUser;
import by.academy.pharmacy.service.database.PrescriptionRequestDaoService;
import by.academy.pharmacy.service.database.UserDaoService;
import by.academy.pharmacy.service.database.impl.PrescriptionRequestDaoServiceImpl;
import by.academy.pharmacy.service.database.impl.UserDaoServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.COMMAND;
import static by.academy.pharmacy.entity.Constant.JSP_CLIENT_PRESCRIPTION_REQUESTS_INDEX_JSP;
import static by.academy.pharmacy.entity.Constant.ORDER_OBJECT;
import static by.academy.pharmacy.entity.Constant.PRESCRIPTION_REQUESTS;
import static by.academy.pharmacy.entity.Constant.SEARCH_VALUE;
import static by.academy.pharmacy.entity.Constant.USER;

public final class ReadPaginatedUserPrescriptionRequestsCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final PrescriptionRequestDaoService service = new PrescriptionRequestDaoServiceImpl();
    /**
     * service working with dao layer.
     */
    private final UserDaoService userService = new UserDaoServiceImpl();
    /**
     * extracts PaginationObject from request.
     */
    private final Extractor<PaginationObject<PrescriptionRequestEntity>> paginationObjectExtractor
            = new PaginationObjectExtractor<>();
    /**
     * extracts OrderObject from request.
     */
    private final Extractor<OrderObject> orderObjectExtractor = new OrderObjectExtractor();

    @Override
    public String execute(final HttpServletRequest request) {
        request.setAttribute(COMMAND, request.getParameter(COMMAND));
        PaginationObject<PrescriptionRequestEntity> paginationObject
                = paginationObjectExtractor.extract(request);
        OrderObject orderObject = orderObjectExtractor.extract(request);
        String searchValue = request.getParameter(SEARCH_VALUE);
        SessionUser sessionUser = (SessionUser) request.getSession().getAttribute(USER);
        UserDTO userDTO = userService.readById(sessionUser.getHealthCareCardNumber());
        request.setAttribute(SEARCH_VALUE, searchValue);
        request.setAttribute(ORDER_OBJECT, orderObject);
        request.setAttribute(PRESCRIPTION_REQUESTS,
                service.readAllWithParametersByUser(paginationObject, orderObject, searchValue,
                        userDTO));
        return JSP_CLIENT_PRESCRIPTION_REQUESTS_INDEX_JSP;
    }
}
