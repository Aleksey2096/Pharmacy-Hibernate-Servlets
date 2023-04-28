package by.academy.pharmacy.controller.command.impl.medicineProduct;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.service.database.MedicineProductDaoService;
import by.academy.pharmacy.service.database.impl.MedicineProductDaoServiceImpl;
import by.academy.pharmacy.service.util.RequestDataUtil;
import jakarta.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.MEDICINE_PRODUCT_ID_DB;
import static by.academy.pharmacy.entity.Constant.PREVIOUS_REQUEST_LINK;

public final class DeleteMedicineProductCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final MedicineProductDaoService service = new MedicineProductDaoServiceImpl();

    @Override
    public String execute(final HttpServletRequest request) {
        service.deleteById(RequestDataUtil.getLong(MEDICINE_PRODUCT_ID_DB, request));
        return request.getParameter(PREVIOUS_REQUEST_LINK);
    }
}
