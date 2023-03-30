package by.academy.pharmacy.service.database;

import by.academy.pharmacy.dto.PrescriptionDTO;
import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.entity.PrescriptionEntity;

public interface PrescriptionDaoService
        extends DaoService<PrescriptionEntity, PrescriptionDTO, Long> {
    PaginationObject<PrescriptionDTO> readAllWithParametersByUser(
            final PaginationObject<PrescriptionEntity> pagination,
            final OrderObject orderObject,
            final String searchValue, final UserDTO userDTO);
}
