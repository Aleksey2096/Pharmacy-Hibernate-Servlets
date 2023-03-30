package by.academy.pharmacy.dao;

import by.academy.pharmacy.entity.MedicineEntity;
import by.academy.pharmacy.entity.MedicineProductEntity;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;

public interface MedicineProductDAO extends DAO<MedicineProductEntity, Long> {
    PaginationObject<MedicineProductEntity> selectAllWithParameters(
            final PaginationObject<MedicineProductEntity> pagination,
            final OrderObject orderObject,
            final String searchValue);

    PaginationObject<MedicineProductEntity> selectAllWithParametersByMedicine(
            final PaginationObject<MedicineProductEntity> pagination,
            final OrderObject orderObject,
            final String searchValue, final MedicineEntity medicineEntity);
}
