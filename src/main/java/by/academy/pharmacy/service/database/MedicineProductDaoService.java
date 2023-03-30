package by.academy.pharmacy.service.database;

import by.academy.pharmacy.dto.MedicineDTO;
import by.academy.pharmacy.dto.MedicineProductDTO;
import by.academy.pharmacy.entity.MedicineProductEntity;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;

public interface MedicineProductDaoService
        extends DaoService<MedicineProductEntity, MedicineProductDTO, Long> {
    PaginationObject<MedicineProductDTO> readAllWithParameters(
            PaginationObject<MedicineProductEntity> pagination,
            OrderObject orderObject,
            String searchValue);

    PaginationObject<MedicineProductDTO> readAllWithParametersByMedicine(
            PaginationObject<MedicineProductEntity> pagination,
            OrderObject orderObject,
            String searchValue, MedicineDTO medicineDTO);
}
