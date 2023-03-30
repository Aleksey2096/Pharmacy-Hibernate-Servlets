package by.academy.pharmacy.controller.command.impl.producer;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.controller.extractor.impl.ProducerDtoExtractor;
import by.academy.pharmacy.dto.ProducerDTO;
import by.academy.pharmacy.service.database.ProducerDaoService;
import by.academy.pharmacy.service.database.impl.ProducerDaoServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.PREVIOUS_REQUEST_LINK;

public final class SaveUpdatedProducerCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final ProducerDaoService service = new ProducerDaoServiceImpl();
    /**
     * extracts ProducerDTO objects from request.
     */
    private final Extractor<ProducerDTO> extractor = new ProducerDtoExtractor();

    @Override
    public String execute(final HttpServletRequest request) {
        service.update(extractor.extract(request));
        return request.getParameter(PREVIOUS_REQUEST_LINK);
    }
}
