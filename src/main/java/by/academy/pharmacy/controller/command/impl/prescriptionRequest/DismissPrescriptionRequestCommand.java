package by.academy.pharmacy.controller.command.impl.prescriptionRequest;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.dto.PrescriptionRequestDTO;
import by.academy.pharmacy.entity.PrescriptionRequestStatus;
import by.academy.pharmacy.service.database.PrescriptionRequestDaoService;
import by.academy.pharmacy.service.database.impl.PrescriptionRequestDaoServiceImpl;
import by.academy.pharmacy.service.util.RequestDataUtil;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.PRESCRIPTION_REQUEST_ID_DB;
import static by.academy.pharmacy.entity.Constant.PREVIOUS_REQUEST_LINK;

public final class DismissPrescriptionRequestCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final PrescriptionRequestDaoService service
            = new PrescriptionRequestDaoServiceImpl();

    @Override
    public String execute(final HttpServletRequest request) {
        PrescriptionRequestDTO prescriptionRequestDTO = service.readById(
                RequestDataUtil.getLong(PRESCRIPTION_REQUEST_ID_DB, request));
        prescriptionRequestDTO.setPrescriptionRequestStatus(
                PrescriptionRequestStatus.DISMISSED);
        service.update(prescriptionRequestDTO);
        return request.getParameter(PREVIOUS_REQUEST_LINK);
    }
}
