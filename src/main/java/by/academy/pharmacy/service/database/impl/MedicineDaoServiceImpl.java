package by.academy.pharmacy.service.database.impl;

import by.academy.pharmacy.dao.DAO;
import by.academy.pharmacy.dao.MedicineDAO;
import by.academy.pharmacy.dao.impl.MedicineDaoImpl;
import by.academy.pharmacy.dto.MedicineDTO;
import by.academy.pharmacy.entity.MedicineEntity;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.service.database.MedicineDaoService;
import by.academy.pharmacy.service.mapping.Converter;
import by.academy.pharmacy.service.mapping.impl.MedicineConverter;

public final class MedicineDaoServiceImpl implements MedicineDaoService {
    private final MedicineDAO dao = new MedicineDaoImpl();
    private final Converter<MedicineEntity, MedicineDTO> converter
            = new MedicineConverter();

    @Override
    public DAO<MedicineEntity, Long> getDAO() {
        return dao;
    }

    @Override
    public Converter<MedicineEntity, MedicineDTO> getConverter() {
        return converter;
    }

    @Override
    public PaginationObject<MedicineDTO> readAllWithParameters(
            final PaginationObject<MedicineEntity> pagination,
            final OrderObject orderObject,
            final String searchValue) {
        return converter.convertToDtoPaginationObject(
                dao.selectAllWithParameters(pagination, orderObject,
                        searchValue));
    }
}
