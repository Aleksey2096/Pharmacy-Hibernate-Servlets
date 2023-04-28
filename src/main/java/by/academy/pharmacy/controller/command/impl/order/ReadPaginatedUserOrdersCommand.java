package by.academy.pharmacy.controller.command.impl.order;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.controller.extractor.impl.OrderObjectExtractor;
import by.academy.pharmacy.controller.extractor.impl.PaginationObjectExtractor;
import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.entity.OrderEntity;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.entity.SessionUser;
import by.academy.pharmacy.service.database.OrderDaoService;
import by.academy.pharmacy.service.database.UserDaoService;
import by.academy.pharmacy.service.database.impl.OrderDaoServiceImpl;
import by.academy.pharmacy.service.database.impl.UserDaoServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.COMMAND;
import static by.academy.pharmacy.entity.Constant.JSP_CLIENT_ORDERS_INDEX_JSP;
import static by.academy.pharmacy.entity.Constant.ORDERS;
import static by.academy.pharmacy.entity.Constant.ORDER_OBJECT;
import static by.academy.pharmacy.entity.Constant.SEARCH_VALUE;
import static by.academy.pharmacy.entity.Constant.USER;

public final class ReadPaginatedUserOrdersCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final OrderDaoService service = new OrderDaoServiceImpl();
    /**
     * service working with dao layer.
     */
    private final UserDaoService userService = new UserDaoServiceImpl();
    /**
     * extracts PaginationObject from request.
     */
    private final Extractor<PaginationObject<OrderEntity>> paginationObjectExtractor
            = new PaginationObjectExtractor<>();
    /**
     * extracts OrderObject from request.
     */
    private final Extractor<OrderObject> orderObjectExtractor = new OrderObjectExtractor();

    @Override
    public String execute(final HttpServletRequest request) {
        request.setAttribute(COMMAND, request.getParameter(COMMAND));
        PaginationObject<OrderEntity> paginationObject = paginationObjectExtractor.extract(request);
        OrderObject orderObject = orderObjectExtractor.extract(request);
        String searchValue = request.getParameter(SEARCH_VALUE);
        SessionUser sessionUser = (SessionUser) request.getSession().getAttribute(USER);
        UserDTO userDTO = userService.readById(sessionUser.getHealthCareCardNumber());
        request.setAttribute(SEARCH_VALUE, searchValue);
        request.setAttribute(ORDER_OBJECT, orderObject);
        request.setAttribute(ORDERS,
                service.readAllWithParametersByUser(paginationObject, orderObject, searchValue,
                        userDTO));
        return JSP_CLIENT_ORDERS_INDEX_JSP;
    }
}
