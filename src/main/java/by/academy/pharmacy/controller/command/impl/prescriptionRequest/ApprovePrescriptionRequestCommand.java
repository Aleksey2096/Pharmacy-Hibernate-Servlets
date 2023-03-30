package by.academy.pharmacy.controller.command.impl.prescriptionRequest;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.controller.extractor.impl.PrescriptionDtoExtractor;
import by.academy.pharmacy.dto.MedicineProductDTO;
import by.academy.pharmacy.dto.PrescriptionDTO;
import by.academy.pharmacy.dto.PrescriptionRequestDTO;
import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.entity.PrescriptionRequestStatus;
import by.academy.pharmacy.service.database.MedicineProductDaoService;
import by.academy.pharmacy.service.database.PrescriptionDaoService;
import by.academy.pharmacy.service.database.PrescriptionRequestDaoService;
import by.academy.pharmacy.service.database.UserDaoService;
import by.academy.pharmacy.service.database.impl.MedicineProductDaoServiceImpl;
import by.academy.pharmacy.service.database.impl.PrescriptionDaoServiceImpl;
import by.academy.pharmacy.service.database.impl.PrescriptionRequestDaoServiceImpl;
import by.academy.pharmacy.service.database.impl.UserDaoServiceImpl;
import by.academy.pharmacy.service.util.RequestDataUtil;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.HEALTH_CARE_CARD_NUMBER_DB;
import static by.academy.pharmacy.entity.Constant.MEDICINE_PRODUCT_ID_DB;
import static by.academy.pharmacy.entity.Constant.PRESCRIPTION_REQUEST_ID_DB;
import static by.academy.pharmacy.entity.Constant.PREVIOUS_REQUEST_LINK_APPROVED;

public final class ApprovePrescriptionRequestCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final PrescriptionDaoService service
            = new PrescriptionDaoServiceImpl();
    /**
     * service working with dao layer.
     */
    private final PrescriptionRequestDaoService prescriptionRequestDaoService
            = new PrescriptionRequestDaoServiceImpl();
    /**
     * service working with dao layer.
     */
    private final UserDaoService userDaoService = new UserDaoServiceImpl();
    /**
     * service working with dao layer.
     */
    private final MedicineProductDaoService medicineProductDaoService
            = new MedicineProductDaoServiceImpl();
    /**
     * extracts ProducerDTO objects from request.
     */
    private final Extractor<PrescriptionDTO> extractor
            = new PrescriptionDtoExtractor();

    @Override
    public String execute(final HttpServletRequest request) {
        PrescriptionDTO prescriptionDTO = extractor.extract(request);
        MedicineProductDTO medicineProductDTO
                = medicineProductDaoService.readById(
                RequestDataUtil.getLong(MEDICINE_PRODUCT_ID_DB, request));
        UserDTO userDTO = userDaoService.readById(
                RequestDataUtil.getLong(HEALTH_CARE_CARD_NUMBER_DB, request));
        prescriptionDTO.setMedicineProductDTO(medicineProductDTO);
        prescriptionDTO.setUserDTO(userDTO);
        service.create(prescriptionDTO);
        PrescriptionRequestDTO prescriptionRequestDTO
                = prescriptionRequestDaoService.readById(
                RequestDataUtil.getLong(PRESCRIPTION_REQUEST_ID_DB, request));
        prescriptionRequestDTO.setPrescriptionRequestStatus(
                PrescriptionRequestStatus.APPROVED);
        prescriptionRequestDaoService.update(prescriptionRequestDTO);
        return request.getParameter(PREVIOUS_REQUEST_LINK_APPROVED);
    }
}
