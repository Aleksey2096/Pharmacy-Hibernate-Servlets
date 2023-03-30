package by.academy.pharmacy.controller.command.impl.user;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.service.database.UserDaoService;
import by.academy.pharmacy.service.database.impl.UserDaoServiceImpl;
import by.academy.pharmacy.service.util.RequestDataUtil;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.HEALTH_CARE_CARD_NUMBER_DB;
import static by.academy.pharmacy.entity.Constant.PREVIOUS_REQUEST_LINK;

public final class DeleteUserCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final UserDaoService service = new UserDaoServiceImpl();

    @Override
    public String execute(final HttpServletRequest request) {
        service.deleteById(
                RequestDataUtil.getLong(HEALTH_CARE_CARD_NUMBER_DB, request));
        return request.getParameter(PREVIOUS_REQUEST_LINK);
    }
}
