package by.academy.pharmacy.controller.command.impl.medicine;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.controller.extractor.impl.MedicineDtoExtractor;
import by.academy.pharmacy.dto.MedicineDTO;
import by.academy.pharmacy.dto.ProducerDTO;
import by.academy.pharmacy.service.database.MedicineDaoService;
import by.academy.pharmacy.service.database.ProducerDaoService;
import by.academy.pharmacy.service.database.impl.MedicineDaoServiceImpl;
import by.academy.pharmacy.service.database.impl.ProducerDaoServiceImpl;
import by.academy.pharmacy.service.util.RequestDataUtil;
import jakarta.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.PREVIOUS_REQUEST_LINK;
import static by.academy.pharmacy.entity.Constant.PRODUCER_ID_DB;

public final class SaveUpdatedMedicineCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final MedicineDaoService service = new MedicineDaoServiceImpl();
    /**
     * service working with dao layer.
     */
    private final ProducerDaoService producerDaoService
            = new ProducerDaoServiceImpl();
    /**
     * extracts ProducerDTO objects from request.
     */
    private final Extractor<MedicineDTO> extractor = new MedicineDtoExtractor();

    @Override
    public String execute(final HttpServletRequest request) {
        MedicineDTO medicineDTO = extractor.extract(request);
        ProducerDTO producerDTO = producerDaoService.readById(
                RequestDataUtil.getLong(PRODUCER_ID_DB, request));
        medicineDTO.setProducerDTO(producerDTO);
        service.update(medicineDTO);
        return request.getParameter(PREVIOUS_REQUEST_LINK);
    }
}
