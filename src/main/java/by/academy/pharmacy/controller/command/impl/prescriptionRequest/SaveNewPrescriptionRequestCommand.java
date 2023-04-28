package by.academy.pharmacy.controller.command.impl.prescriptionRequest;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.controller.extractor.impl.PrescriptionRequestDtoExtractor;
import by.academy.pharmacy.dto.PrescriptionRequestDTO;
import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.entity.SessionUser;
import by.academy.pharmacy.service.database.PrescriptionRequestDaoService;
import by.academy.pharmacy.service.database.UserDaoService;
import by.academy.pharmacy.service.database.impl.PrescriptionRequestDaoServiceImpl;
import by.academy.pharmacy.service.database.impl.UserDaoServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.PREVIOUS_REQUEST_LINK;
import static by.academy.pharmacy.entity.Constant.USER;

public final class SaveNewPrescriptionRequestCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final PrescriptionRequestDaoService service = new PrescriptionRequestDaoServiceImpl();
    /**
     * service working with dao layer.
     */
    private final UserDaoService userService = new UserDaoServiceImpl();
    /**
     * extracts PrescriptionRequestDTO objects from request.
     */
    private final Extractor<PrescriptionRequestDTO> extractor
            = new PrescriptionRequestDtoExtractor();

    @Override
    public String execute(final HttpServletRequest request) {
        PrescriptionRequestDTO prescriptionRequestDTO = extractor.extract(request);
        SessionUser sessionUser = (SessionUser) request.getSession().getAttribute(USER);
        UserDTO userDTO = userService.readById(sessionUser.getHealthCareCardNumber());
        prescriptionRequestDTO.setUserDTO(userDTO);
        service.create(prescriptionRequestDTO);
        return request.getParameter(PREVIOUS_REQUEST_LINK);
    }
}
