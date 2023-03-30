package by.academy.pharmacy.controller.command.impl.user;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.dto.MedicineProductDTO;
import by.academy.pharmacy.entity.SessionUser;
import by.academy.pharmacy.service.database.MedicineProductDaoService;
import by.academy.pharmacy.service.database.UserDaoService;
import by.academy.pharmacy.service.database.impl.MedicineProductDaoServiceImpl;
import by.academy.pharmacy.service.database.impl.UserDaoServiceImpl;
import by.academy.pharmacy.service.util.RequestDataUtil;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.JSP_COMMON_LOGIN_JSP;
import static by.academy.pharmacy.entity.Constant.MEDICINE_PRODUCT_ID_DB;
import static by.academy.pharmacy.entity.Constant.PREVIOUS_REQUEST_LINK;
import static by.academy.pharmacy.entity.Constant.USER;

public final class AddToCartCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final UserDaoService service = new UserDaoServiceImpl();
    /**
     * service working with dao layer.
     */
    private final MedicineProductDaoService medicineProductDaoService
            = new MedicineProductDaoServiceImpl();

    @Override
    public String execute(final HttpServletRequest request) {
        if (request.getSession().getAttribute(USER) == null) {
            request.setAttribute(PREVIOUS_REQUEST_LINK,
                    request.getParameter(PREVIOUS_REQUEST_LINK));
            return JSP_COMMON_LOGIN_JSP;
        }
        MedicineProductDTO medicineProductDTO
                = medicineProductDaoService.readById(
                RequestDataUtil.getLong(MEDICINE_PRODUCT_ID_DB, request));
        service.addToCart(((SessionUser) request.getSession()
                        .getAttribute(USER)).getHealthCareCardNumber(),
                medicineProductDTO);
        return null;
    }
}
