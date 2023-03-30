package by.academy.pharmacy.controller.command.impl;

import by.academy.pharmacy.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.DISPATCHER_READ_PAGINATED_CLIENT_MEDICINES_URL;

public final class LogoutCommand implements Command {

    @Override
    public String execute(final HttpServletRequest request) {
        request.getSession().invalidate();
        return DISPATCHER_READ_PAGINATED_CLIENT_MEDICINES_URL;
    }
}
