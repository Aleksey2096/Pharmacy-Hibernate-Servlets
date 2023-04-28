package by.academy.pharmacy.dao;

import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.entity.PrescriptionRequestEntity;
import by.academy.pharmacy.entity.UserEntity;

public interface PrescriptionRequestDAO extends DAO<PrescriptionRequestEntity, Long> {
    PaginationObject<PrescriptionRequestEntity> selectAllWithParameters(
            final PaginationObject<PrescriptionRequestEntity> pagination,
            final OrderObject orderObject, final String searchValue);

    PaginationObject<PrescriptionRequestEntity> selectAllUnprocessedWithParameters(
            final PaginationObject<PrescriptionRequestEntity> pagination,
            final OrderObject orderObject, final String searchValue);

    PaginationObject<PrescriptionRequestEntity> selectAllWithParametersByUser(
            final PaginationObject<PrescriptionRequestEntity> pagination,
            final OrderObject orderObject, final String searchValue, final UserEntity userEntity);
}
