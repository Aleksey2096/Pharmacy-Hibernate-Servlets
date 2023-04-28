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

import static by.academy.pharmacy.entity.Constant.PREVIOUS_REQUEST_LINK;

public final class SaveUpdatedUserCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final UserDaoService service = new UserDaoServiceImpl();
    /**
     * extracts UserDTO objects from request.
     */
    private final Extractor<UserDTO> userDtoExtractor = new UserDtoExtractor();
    /**
     * extracts PersonalInfoDTO objects from request.
     */
    private final Extractor<PersonalInfoDTO> personalInfoDtoExtractor
            = new PersonalInfoDtoExtractor();
    /**
     * extracts AddressDTO objects from request.
     */
    private final Extractor<AddressDTO> addressDtoExtractor = new AddressDtoExtractor();

    @Override
    public String execute(final HttpServletRequest request) {
        UserDTO userDTO = userDtoExtractor.extract(request);
        PersonalInfoDTO personalInfoDTO = personalInfoDtoExtractor.extract(request);
        AddressDTO addressDTO = addressDtoExtractor.extract(request);
        personalInfoDTO.setAddressDTO(addressDTO);
        userDTO.setPersonalInfoDTO(personalInfoDTO);
        service.update(userDTO);
        return request.getParameter(PREVIOUS_REQUEST_LINK);
    }
}
