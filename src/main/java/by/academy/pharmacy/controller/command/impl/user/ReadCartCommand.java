package by.academy.pharmacy.controller.command.impl.user;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.dto.MedicineProductDTO;
import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.entity.SessionUser;
import by.academy.pharmacy.service.database.UserDaoService;
import by.academy.pharmacy.service.database.impl.UserDaoServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

import static by.academy.pharmacy.entity.Constant.COMMAND;
import static by.academy.pharmacy.entity.Constant.JSP_CLIENT_ORDERS_CART_JSP;
import static by.academy.pharmacy.entity.Constant.MEDICINE_PRODUCTS;
import static by.academy.pharmacy.entity.Constant.USER;

public final class ReadCartCommand implements Command {
	/**
	 * service working with dao layer.
	 */
	private final UserDaoService service = new UserDaoServiceImpl();

	@Override
	public String execute(final HttpServletRequest request) {
		request.setAttribute(COMMAND, request.getParameter(COMMAND));
		Long healthCareCardNumber = ((SessionUser) request.getSession()
				.getAttribute(USER))
				.getHealthCareCardNumber();
		UserDTO userDTO = service.readById(healthCareCardNumber);
		Set<MedicineProductDTO> cart = service.readCart(healthCareCardNumber);
		request.setAttribute(USER, userDTO);
		request.setAttribute(MEDICINE_PRODUCTS, cart);
		return JSP_CLIENT_ORDERS_CART_JSP;
	}
}
