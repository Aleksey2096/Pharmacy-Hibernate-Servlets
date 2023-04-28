package by.academy.pharmacy.controller.command.impl.user;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.controller.extractor.impl.OrderObjectExtractor;
import by.academy.pharmacy.controller.extractor.impl.PaginationObjectExtractor;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.entity.UserEntity;
import by.academy.pharmacy.service.database.UserDaoService;
import by.academy.pharmacy.service.database.impl.UserDaoServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.COMMAND;
import static by.academy.pharmacy.entity.Constant.JSP_ADMINISTRATOR_USERS_INDEX_JSP;
import static by.academy.pharmacy.entity.Constant.ORDER_OBJECT;
import static by.academy.pharmacy.entity.Constant.SEARCH_VALUE;
import static by.academy.pharmacy.entity.Constant.USERS;

public final class ReadPaginatedUsersCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final UserDaoService service = new UserDaoServiceImpl();
    /**
     * extracts PaginationObject from request.
     */
    private final Extractor<PaginationObject<UserEntity>> paginationObjectExtractor
            = new PaginationObjectExtractor<>();
    /**
     * extracts OrderObject from request.
     */
    private final Extractor<OrderObject> orderObjectExtractor = new OrderObjectExtractor();

    @Override
    public String execute(final HttpServletRequest request) {
        request.setAttribute(COMMAND, request.getParameter(COMMAND));
        PaginationObject<UserEntity> paginationObject = paginationObjectExtractor.extract(request);
        OrderObject orderObject = orderObjectExtractor.extract(request);
        String searchValue = request.getParameter(SEARCH_VALUE);
        request.setAttribute(SEARCH_VALUE, searchValue);
        request.setAttribute(ORDER_OBJECT, orderObject);
        request.setAttribute(USERS,
                service.readAllWithParameters(paginationObject, orderObject, searchValue));
        return JSP_ADMINISTRATOR_USERS_INDEX_JSP;
    }
}
