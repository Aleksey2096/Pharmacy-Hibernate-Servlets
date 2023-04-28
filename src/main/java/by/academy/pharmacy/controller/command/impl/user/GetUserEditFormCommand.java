package by.academy.pharmacy.controller.command.impl.user;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.entity.Role;
import by.academy.pharmacy.service.database.UserDaoService;
import by.academy.pharmacy.service.database.impl.UserDaoServiceImpl;
import by.academy.pharmacy.service.util.RequestDataUtil;
import jakarta.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.HEALTH_CARE_CARD_NUMBER_DB;
import static by.academy.pharmacy.entity.Constant.JSP_ADMINISTRATOR_USERS_EDIT_JSP;
import static by.academy.pharmacy.entity.Constant.PREVIOUS_REQUEST_LINK;
import static by.academy.pharmacy.entity.Constant.ROLES;
import static by.academy.pharmacy.entity.Constant.USER;

public final class GetUserEditFormCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final UserDaoService service = new UserDaoServiceImpl();

    @Override
    public String execute(final HttpServletRequest request) {
        UserDTO userDTO = service.readById(
                RequestDataUtil.getLong(HEALTH_CARE_CARD_NUMBER_DB, request));
        request.setAttribute(USER, userDTO);
        request.setAttribute(ROLES, Role.values());
        request.setAttribute(PREVIOUS_REQUEST_LINK, request.getParameter(PREVIOUS_REQUEST_LINK));
        return JSP_ADMINISTRATOR_USERS_EDIT_JSP;
    }
}
