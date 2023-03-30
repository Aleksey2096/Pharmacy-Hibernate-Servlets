package by.academy.pharmacy.controller.command.impl.producer;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.service.database.ProducerDaoService;
import by.academy.pharmacy.service.database.impl.ProducerDaoServiceImpl;
import by.academy.pharmacy.service.util.RequestDataUtil;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.PREVIOUS_REQUEST_LINK;
import static by.academy.pharmacy.entity.Constant.PRODUCER_ID_DB;

public final class DeleteProducerCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final ProducerDaoService service = new ProducerDaoServiceImpl();

    @Override
    public String execute(final HttpServletRequest request) {
        service.deleteById(RequestDataUtil.getLong(PRODUCER_ID_DB, request));
        return request.getParameter(PREVIOUS_REQUEST_LINK);
    }
}
