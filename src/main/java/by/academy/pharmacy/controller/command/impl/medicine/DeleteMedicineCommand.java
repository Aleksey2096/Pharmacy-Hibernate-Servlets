package by.academy.pharmacy.controller.command.impl.medicine;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.service.database.MedicineDaoService;
import by.academy.pharmacy.service.database.impl.MedicineDaoServiceImpl;
import by.academy.pharmacy.service.util.RequestDataUtil;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.MEDICINE_ID_DB;
import static by.academy.pharmacy.entity.Constant.PREVIOUS_REQUEST_LINK;

public final class DeleteMedicineCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final MedicineDaoService service = new MedicineDaoServiceImpl();

    @Override
    public String execute(final HttpServletRequest request) {
        service.deleteById(RequestDataUtil.getLong(MEDICINE_ID_DB, request));
        return request.getParameter(PREVIOUS_REQUEST_LINK);
    }
}
