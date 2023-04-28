package by.academy.pharmacy.controller.command.impl.user;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.controller.extractor.impl.AddressDtoExtractor;
import by.academy.pharmacy.controller.extractor.impl.PersonalInfoDtoExtractor;
import by.academy.pharmacy.controller.extractor.impl.UserDtoExtractor;
import by.academy.pharmacy.dto.AddressDTO;
import by.academy.pharmacy.dto.PersonalInfoDTO;
import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.service.database.UserDaoService;
import by.academy.pharmacy.service.database.impl.UserDaoServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.JSP_COMMON_LOGIN_JSP;
import static by.academy.pharmacy.entity.Constant.LOGIN_MESSAGE;
import static by.academy.pharmacy.entity.Constant.PREVIOUS_REQUEST_LINK;
import static by.academy.pharmacy.entity.Constant.TEXT_SUCCESSFUL_SIGNUP;
import static by.academy.pharmacy.entity.Constant.USER;

public final class SaveNewUserCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final UserDaoService service = new UserDaoServiceImpl();
    /**
     * extracts UserDTO objects from request.
     */
    private final Extractor<UserDTO> extractor = new UserDtoExtractor();
    /**
     * extracts UserDTO objects from request.
     */
    private final Extractor<PersonalInfoDTO> personalInfoDtoExtractor
            = new PersonalInfoDtoExtractor();
    /**
     * extracts UserDTO objects from request.
     */
    private final Extractor<AddressDTO> addressDtoExtractor = new AddressDtoExtractor();

    @Override
    public String execute(final HttpServletRequest request) {
        String page = request.getParameter(PREVIOUS_REQUEST_LINK);
        if (request.getSession().getAttribute(USER) == null) {
            request.setAttribute(PREVIOUS_REQUEST_LINK,
                    request.getParameter(PREVIOUS_REQUEST_LINK));
            request.setAttribute(LOGIN_MESSAGE, TEXT_SUCCESSFUL_SIGNUP);
            page = JSP_COMMON_LOGIN_JSP;
        }
        UserDTO userDTO = extractor.extract(request);
        PersonalInfoDTO personalInfoDTO = personalInfoDtoExtractor.extract(request);
        personalInfoDTO.setAddressDTO(addressDtoExtractor.extract(request));
        userDTO.setPersonalInfoDTO(personalInfoDTO);
        service.create(userDTO);
        return page;
    }
}
