package by.academy.pharmacy.controller.command.impl.medicine;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.dto.MedicineDTO;
import by.academy.pharmacy.dto.ProducerDTO;
import by.academy.pharmacy.service.database.MedicineDaoService;
import by.academy.pharmacy.service.database.ProducerDaoService;
import by.academy.pharmacy.service.database.impl.MedicineDaoServiceImpl;
import by.academy.pharmacy.service.database.impl.ProducerDaoServiceImpl;
import by.academy.pharmacy.service.util.RequestDataUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

import static by.academy.pharmacy.entity.Constant.JSP_PHARMACIST_MEDICINES_EDIT_JSP;
import static by.academy.pharmacy.entity.Constant.MEDICINE;
import static by.academy.pharmacy.entity.Constant.MEDICINE_ID_DB;
import static by.academy.pharmacy.entity.Constant.PREVIOUS_REQUEST_LINK;
import static by.academy.pharmacy.entity.Constant.PRODUCERS;

public final class GetMedicineEditFormCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final MedicineDaoService service = new MedicineDaoServiceImpl();
    /**
     * service working with dao layer.
     */
    private final ProducerDaoService producerDaoService
            = new ProducerDaoServiceImpl();

    @Override
    public String execute(final HttpServletRequest request) {
        MedicineDTO medicineDTO = service
                .readById(RequestDataUtil.getLong(MEDICINE_ID_DB, request));
        request.setAttribute(MEDICINE, medicineDTO);
        Set<ProducerDTO> producerDTOs = producerDaoService.readAll();
        request.setAttribute(PRODUCERS, producerDTOs);
        request.setAttribute(PREVIOUS_REQUEST_LINK,
                request.getParameter(PREVIOUS_REQUEST_LINK));
        return JSP_PHARMACIST_MEDICINES_EDIT_JSP;
    }
}
