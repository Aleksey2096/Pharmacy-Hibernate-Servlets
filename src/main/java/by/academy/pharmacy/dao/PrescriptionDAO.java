package by.academy.pharmacy.dao;

import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.entity.PrescriptionEntity;
import by.academy.pharmacy.entity.UserEntity;

public interface PrescriptionDAO extends DAO<PrescriptionEntity, Long> {
    PaginationObject<PrescriptionEntity> selectAllWithParametersByUser(
            final PaginationObject<PrescriptionEntity> pagination, final OrderObject orderObject,
            final String searchValue, final UserEntity userEntity);
}
