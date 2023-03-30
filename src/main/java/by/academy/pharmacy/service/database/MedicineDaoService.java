package by.academy.pharmacy.service.database;

import by.academy.pharmacy.dto.MedicineDTO;
import by.academy.pharmacy.entity.MedicineEntity;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;

public interface MedicineDaoService
        extends DaoService<MedicineEntity, MedicineDTO, Long> {
    PaginationObject<MedicineDTO> readAllWithParameters(
            PaginationObject<MedicineEntity> pagination,
            OrderObject orderObject, String searchValue);
}
