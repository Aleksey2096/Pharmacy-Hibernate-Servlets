package by.academy.pharmacy.dao;

import by.academy.pharmacy.entity.MedicineEntity;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;

public interface MedicineDAO extends DAO<MedicineEntity, Long> {
    PaginationObject<MedicineEntity> selectAllWithParameters(
            final PaginationObject<MedicineEntity> pagination,
            final OrderObject orderObject,
            final String searchValue);
}
