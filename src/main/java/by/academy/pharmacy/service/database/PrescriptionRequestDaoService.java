package by.academy.pharmacy.service.database;

import by.academy.pharmacy.dto.PrescriptionRequestDTO;
import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.entity.PrescriptionRequestEntity;

public interface PrescriptionRequestDaoService
        extends
        DaoService<PrescriptionRequestEntity, PrescriptionRequestDTO, Long> {
    PaginationObject<PrescriptionRequestDTO> readAllWithParameters(
            PaginationObject<PrescriptionRequestEntity> pagination,
            OrderObject orderObject,
            String searchValue);

    PaginationObject<PrescriptionRequestDTO> readAllUnprocessedWithParameters(
            PaginationObject<PrescriptionRequestEntity> pagination,
            OrderObject orderObject,
            String searchValue);

    PaginationObject<PrescriptionRequestDTO> readAllWithParametersByUser(
            final PaginationObject<PrescriptionRequestEntity> pagination,
            final OrderObject orderObject, final String searchValue,
            final UserDTO userDTO);
}
