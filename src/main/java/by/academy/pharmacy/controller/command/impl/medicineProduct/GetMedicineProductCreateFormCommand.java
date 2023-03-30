package by.academy.pharmacy.controller.command.impl.medicineProduct;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.dto.MedicineDTO;
import by.academy.pharmacy.entity.Form;
import by.academy.pharmacy.service.database.MedicineDaoService;
import by.academy.pharmacy.service.database.impl.MedicineDaoServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

import static by.academy.pharmacy.entity.Constant.FORMS;
import static by.academy.pharmacy.entity.Constant.JSP_PHARMACIST_MEDICINE_PRODUCTS_NEW_JSP;
import static by.academy.pharmacy.entity.Constant.MEDICINES;
import static by.academy.pharmacy.entity.Constant.PREVIOUS_REQUEST_LINK;

public final class GetMedicineProductCreateFormCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final MedicineDaoService medicineDaoService
            = new MedicineDaoServiceImpl();

    @Override
    public String execute(final HttpServletRequest request) {
        request.setAttribute(PREVIOUS_REQUEST_LINK,
                request.getParameter(PREVIOUS_REQUEST_LINK));
        Set<MedicineDTO> medicineDTOs = medicineDaoService.readAll();
        request.setAttribute(MEDICINES, medicineDTOs);
        request.setAttribute(FORMS, Form.values());
        return JSP_PHARMACIST_MEDICINE_PRODUCTS_NEW_JSP;
    }
}
