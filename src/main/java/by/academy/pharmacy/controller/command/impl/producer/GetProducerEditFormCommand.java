package by.academy.pharmacy.controller.command.impl.producer;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.dto.ProducerDTO;
import by.academy.pharmacy.entity.Country;
import by.academy.pharmacy.service.database.ProducerDaoService;
import by.academy.pharmacy.service.database.impl.ProducerDaoServiceImpl;
import by.academy.pharmacy.service.util.RequestDataUtil;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.COUNTRIES;
import static by.academy.pharmacy.entity.Constant.JSP_PHARMACIST_PRODUCERS_EDIT_JSP;
import static by.academy.pharmacy.entity.Constant.PREVIOUS_REQUEST_LINK;
import static by.academy.pharmacy.entity.Constant.PRODUCER;
import static by.academy.pharmacy.entity.Constant.PRODUCER_ID_DB;

public final class GetProducerEditFormCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final ProducerDaoService service = new ProducerDaoServiceImpl();

    @Override
    public String execute(final HttpServletRequest request) {
        ProducerDTO producerDTO = service.readById(
                RequestDataUtil.getLong(PRODUCER_ID_DB, request));
        request.setAttribute(PRODUCER, producerDTO);
        request.setAttribute(COUNTRIES, Country.values());
        request.setAttribute(PREVIOUS_REQUEST_LINK,
                request.getParameter(PREVIOUS_REQUEST_LINK));
        return JSP_PHARMACIST_PRODUCERS_EDIT_JSP;
    }
}
