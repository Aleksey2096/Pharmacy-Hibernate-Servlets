package by.academy.pharmacy.controller.command.impl.medicine;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.controller.extractor.impl.OrderObjectExtractor;
import by.academy.pharmacy.controller.extractor.impl.PaginationObjectExtractor;
import by.academy.pharmacy.entity.MedicineEntity;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.service.database.MedicineDaoService;
import by.academy.pharmacy.service.database.impl.MedicineDaoServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.COMMAND;
import static by.academy.pharmacy.entity.Constant.JSP_PHARMACIST_MEDICINES_INDEX_JSP;
import static by.academy.pharmacy.entity.Constant.MEDICINES;
import static by.academy.pharmacy.entity.Constant.ORDER_OBJECT;
import static by.academy.pharmacy.entity.Constant.SEARCH_VALUE;

public final class ReadPaginatedMedicinesCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final MedicineDaoService service = new MedicineDaoServiceImpl();
    /**
     * extracts PaginationObject from request.
     */
    private final Extractor<PaginationObject<MedicineEntity>>
            paginationObjectExtractor = new PaginationObjectExtractor<>();
    /**
     * extracts OrderObject from request.
     */
    private final Extractor<OrderObject> orderObjectExtractor
            = new OrderObjectExtractor();

    @Override
    public String execute(final HttpServletRequest request) {
        request.setAttribute(COMMAND, request.getParameter(COMMAND));
        PaginationObject<MedicineEntity> paginationObject
                = paginationObjectExtractor
                .extract(request);
        OrderObject orderObject = orderObjectExtractor.extract(request);
        String searchValue = request.getParameter(SEARCH_VALUE);
        request.setAttribute(SEARCH_VALUE, searchValue);
        request.setAttribute(ORDER_OBJECT, orderObject);
        request.setAttribute(MEDICINES,
                service.readAllWithParameters(paginationObject, orderObject,
                        searchValue));
        return JSP_PHARMACIST_MEDICINES_INDEX_JSP;
    }
}
