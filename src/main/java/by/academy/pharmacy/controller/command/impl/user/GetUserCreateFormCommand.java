package by.academy.pharmacy.controller.command.impl.user;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.entity.Role;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.JSP_ADMINISTRATOR_USERS_NEW_JSP;
import static by.academy.pharmacy.entity.Constant.PREVIOUS_REQUEST_LINK;
import static by.academy.pharmacy.entity.Constant.ROLES;

public final class GetUserCreateFormCommand implements Command {
	@Override
	public String execute(final HttpServletRequest request) {
		request.setAttribute(ROLES, Role.values());
		request.setAttribute(PREVIOUS_REQUEST_LINK,
				request.getParameter(PREVIOUS_REQUEST_LINK));
		return JSP_ADMINISTRATOR_USERS_NEW_JSP;
	}
}
