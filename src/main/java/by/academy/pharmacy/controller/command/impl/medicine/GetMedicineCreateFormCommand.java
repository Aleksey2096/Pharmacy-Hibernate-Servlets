package by.academy.pharmacy.controller.command.impl.medicine;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.dto.ProducerDTO;
import by.academy.pharmacy.service.database.ProducerDaoService;
import by.academy.pharmacy.service.database.impl.ProducerDaoServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

import static by.academy.pharmacy.entity.Constant.JSP_PHARMACIST_MEDICINES_NEW_JSP;
import static by.academy.pharmacy.entity.Constant.PREVIOUS_REQUEST_LINK;
import static by.academy.pharmacy.entity.Constant.PRODUCERS;

public final class GetMedicineCreateFormCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final ProducerDaoService producerDaoService
            = new ProducerDaoServiceImpl();

    @Override
    public String execute(final HttpServletRequest request) {
        request.setAttribute(PREVIOUS_REQUEST_LINK,
                request.getParameter(PREVIOUS_REQUEST_LINK));
        Set<ProducerDTO> producerDTOs = producerDaoService.readAll();
        request.setAttribute(PRODUCERS, producerDTOs);
        return JSP_PHARMACIST_MEDICINES_NEW_JSP;
    }
}
