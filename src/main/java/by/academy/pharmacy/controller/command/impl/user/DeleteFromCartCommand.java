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

import static by.academy.pharmacy.entity.Constant.MEDICINE_PRODUCT_ID_DB;
import static by.academy.pharmacy.entity.Constant.USER;

public final class DeleteFromCartCommand implements Command {
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
        MedicineProductDTO medicineProductDTO
                = medicineProductDaoService.readById(
                RequestDataUtil.getLong(MEDICINE_PRODUCT_ID_DB, request));
        service.deleteFromCart(((SessionUser) request.getSession()
                        .getAttribute(USER)).getHealthCareCardNumber(),
                medicineProductDTO);
        return null;
    }
}
