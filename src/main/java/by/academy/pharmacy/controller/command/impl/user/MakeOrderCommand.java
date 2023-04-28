package by.academy.pharmacy.controller.command.impl.user;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.controller.extractor.impl.OrderDtoListExtractor;
import by.academy.pharmacy.dto.OrderDTO;
import by.academy.pharmacy.dto.PrescriptionDTO;
import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.entity.SessionUser;
import by.academy.pharmacy.service.database.MedicineProductDaoService;
import by.academy.pharmacy.service.database.OrderDaoService;
import by.academy.pharmacy.service.database.PrescriptionDaoService;
import by.academy.pharmacy.service.database.UserDaoService;
import by.academy.pharmacy.service.database.impl.MedicineProductDaoServiceImpl;
import by.academy.pharmacy.service.database.impl.OrderDaoServiceImpl;
import by.academy.pharmacy.service.database.impl.PrescriptionDaoServiceImpl;
import by.academy.pharmacy.service.database.impl.UserDaoServiceImpl;
import by.academy.pharmacy.service.util.ValidatorUtil;
import jakarta.servlet.http.HttpServletRequest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import static by.academy.pharmacy.entity.Constant.DISPATCHER_READ_PAGINATED_CLIENT_MEDICINES_URL;
import static by.academy.pharmacy.entity.Constant.TOTAL_PRICE;
import static by.academy.pharmacy.entity.Constant.USER;

public final class MakeOrderCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final UserDaoService service = new UserDaoServiceImpl();
    /**
     * service working with dao layer.
     */
    private final MedicineProductDaoService medicineProductDaoService
            = new MedicineProductDaoServiceImpl();
    /**
     * service working with dao layer.
     */
    private final OrderDaoService orderDaoService = new OrderDaoServiceImpl();
    /**
     * service working with dao layer.
     */
    private final PrescriptionDaoService prescriptionDaoService = new PrescriptionDaoServiceImpl();
    /**
     * extracts OrderObject from request.
     */
    private final Extractor<List<OrderDTO>> extractor = new OrderDtoListExtractor();

    @Override
    public String execute(final HttpServletRequest request) {
        BigDecimal totalPrice = new BigDecimal(request.getParameter(TOTAL_PRICE));
        UserDTO userDTO = service.readById(
                ((SessionUser) request.getSession().getAttribute(USER)).getHealthCareCardNumber());
        if (ValidatorUtil.isEnoughAccountFunds(userDTO, totalPrice)) {
            List<OrderDTO> orderDTOs = extractor.extract(request);
            orderDTOs.forEach(x -> {
                x.setUserDTO(userDTO);
                x.setMedicineProductDTO(
                        medicineProductDaoService.readById(x.getMedicineProductDTO().getId()));
            });
            Set<PrescriptionDTO> userPrescriptions = service.readPrescriptions(
                    userDTO.getHealthCareCardNumber());
            if (ValidatorUtil.isValidOrders(userPrescriptions, orderDTOs)) {
                userDTO.getPersonalInfoDTO().setPersonalAccount(
                        userDTO.getPersonalInfoDTO().getPersonalAccount().subtract(totalPrice));
                service.update(userDTO);
                for (PrescriptionDTO prescriptionDTO : userPrescriptions) {
                    for (OrderDTO orderDTO : orderDTOs) {
                        if (prescriptionDTO.getMedicineProductDTO()
                                .equals(orderDTO.getMedicineProductDTO())) {
                            if (prescriptionDTO.getAmount() == orderDTO.getAmount()) {
                                prescriptionDaoService.deleteById(prescriptionDTO.getId());
                            } else {
                                prescriptionDTO.setAmount(
                                        prescriptionDTO.getAmount() - orderDTO.getAmount());
                                prescriptionDaoService.update(prescriptionDTO);
                            }
                        }
                    }
                }
                orderDTOs.forEach(x -> {
                    service.deleteFromCart(userDTO.getHealthCareCardNumber(),
                            x.getMedicineProductDTO());
                    orderDaoService.create(x);
                    x.getMedicineProductDTO()
                            .setAmount(x.getMedicineProductDTO().getAmount() - x.getAmount());
                    medicineProductDaoService.update(x.getMedicineProductDTO());
                });
            }
        }
        return DISPATCHER_READ_PAGINATED_CLIENT_MEDICINES_URL;
    }
}
