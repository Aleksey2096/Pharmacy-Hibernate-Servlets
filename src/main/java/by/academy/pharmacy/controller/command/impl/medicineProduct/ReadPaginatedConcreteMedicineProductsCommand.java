package by.academy.pharmacy.controller.command.impl.medicineProduct;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.controller.extractor.impl.OrderObjectExtractor;
import by.academy.pharmacy.controller.extractor.impl.PaginationObjectExtractor;
import by.academy.pharmacy.dto.MedicineDTO;
import by.academy.pharmacy.entity.MedicineProductEntity;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.service.database.MedicineDaoService;
import by.academy.pharmacy.service.database.MedicineProductDaoService;
import by.academy.pharmacy.service.database.impl.MedicineDaoServiceImpl;
import by.academy.pharmacy.service.database.impl.MedicineProductDaoServiceImpl;
import by.academy.pharmacy.service.util.RequestDataUtil;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.COMMAND;
import static by.academy.pharmacy.entity.Constant.JSP_CLIENT_MEDICINE_PRODUCTS_INDEX_JSP;
import static by.academy.pharmacy.entity.Constant.MEDICINE_ID_DB;
import static by.academy.pharmacy.entity.Constant.MEDICINE_PRODUCTS;
import static by.academy.pharmacy.entity.Constant.ORDER_OBJECT;
import static by.academy.pharmacy.entity.Constant.SEARCH_VALUE;

public final class ReadPaginatedConcreteMedicineProductsCommand
        implements Command {
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
     * extracts PaginationObject from request.
     */
    private final Extractor<PaginationObject<MedicineProductEntity>>
            paginationObjectExtractor = new PaginationObjectExtractor<>();
    /**
     * extracts OrderObject from request.
     */
    private final Extractor<OrderObject> orderObjectExtractor
            = new OrderObjectExtractor();

    @Override
    public String execute(final HttpServletRequest request) {
        request.setAttribute(COMMAND, request.getParameter(COMMAND));
        PaginationObject<MedicineProductEntity> paginationObject
                = paginationObjectExtractor
                .extract(request);
        OrderObject orderObject = orderObjectExtractor.extract(request);
        String searchValue = request.getParameter(SEARCH_VALUE);
        MedicineDTO medicineDTO = medicineDaoService
                .readById(RequestDataUtil.getLong(MEDICINE_ID_DB, request));
        request.setAttribute(SEARCH_VALUE, searchValue);
        request.setAttribute(ORDER_OBJECT, orderObject);
        request.setAttribute(MEDICINE_PRODUCTS,
                service.readAllWithParametersByMedicine(
                        paginationObject, orderObject, searchValue,
                        medicineDTO));
        return JSP_CLIENT_MEDICINE_PRODUCTS_INDEX_JSP;
    }
}
