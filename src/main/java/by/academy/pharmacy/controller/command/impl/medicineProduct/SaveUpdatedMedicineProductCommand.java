package by.academy.pharmacy.controller.command.impl.medicineProduct;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.controller.extractor.impl.MedicineProductDtoExtractor;
import by.academy.pharmacy.dto.MedicineDTO;
import by.academy.pharmacy.dto.MedicineProductDTO;
import by.academy.pharmacy.service.database.MedicineDaoService;
import by.academy.pharmacy.service.database.MedicineProductDaoService;
import by.academy.pharmacy.service.database.impl.MedicineDaoServiceImpl;
import by.academy.pharmacy.service.database.impl.MedicineProductDaoServiceImpl;
import by.academy.pharmacy.service.util.RequestDataUtil;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.MEDICINE_ID_DB;
import static by.academy.pharmacy.entity.Constant.PREVIOUS_REQUEST_LINK;

public final class SaveUpdatedMedicineProductCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final MedicineProductDaoService service
            = new MedicineProductDaoServiceImpl();
    /**
     * service working with dao layer.
     */
    private final MedicineDaoService medicineDaoService
            = new MedicineDaoServiceImpl();
    /**
     * extracts ProducerDTO objects from request.
     */
    private final Extractor<MedicineProductDTO> extractor
            = new MedicineProductDtoExtractor();

    @Override
    public String execute(final HttpServletRequest request) {
        MedicineProductDTO medicineProductDTO = extractor.extract(request);
        MedicineDTO medicineDTO = medicineDaoService
                .readById(RequestDataUtil.getLong(MEDICINE_ID_DB, request));
        medicineProductDTO.setMedicineDTO(medicineDTO);
        service.update(medicineProductDTO);
        return request.getParameter(PREVIOUS_REQUEST_LINK);
    }
}
