package by.academy.pharmacy.service.database.impl;

import by.academy.pharmacy.converter.Converter;
import by.academy.pharmacy.converter.impl.MedicineConverter;
import by.academy.pharmacy.converter.impl.MedicineProductConverter;
import by.academy.pharmacy.dao.DAO;
import by.academy.pharmacy.dao.MedicineProductDAO;
import by.academy.pharmacy.dao.impl.MedicineProductDaoImpl;
import by.academy.pharmacy.dto.MedicineDTO;
import by.academy.pharmacy.dto.MedicineProductDTO;
import by.academy.pharmacy.entity.MedicineEntity;
import by.academy.pharmacy.entity.MedicineProductEntity;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.service.database.MedicineProductDaoService;

public final class MedicineProductDaoServiceImpl implements MedicineProductDaoService {
    private final MedicineProductDAO dao = new MedicineProductDaoImpl();
    private final Converter<MedicineProductEntity, MedicineProductDTO> converter
            = new MedicineProductConverter();
    private final Converter<MedicineEntity, MedicineDTO> medicineConverter
            = new MedicineConverter();

    @Override
    public DAO<MedicineProductEntity, Long> getDAO() {
        return dao;
    }

    @Override
    public Converter<MedicineProductEntity, MedicineProductDTO> getConverter() {
        return converter;
    }

    @Override
    public PaginationObject<MedicineProductDTO> readAllWithParameters(
            final PaginationObject<MedicineProductEntity> pagination, final OrderObject orderObject,
            final String searchValue) {
        return converter.convertToDtoPaginationObject(
                dao.selectAllWithParameters(pagination, orderObject, searchValue));
    }

    @Override
    public PaginationObject<MedicineProductDTO> readAllWithParametersByMedicine(
            final PaginationObject<MedicineProductEntity> pagination, final OrderObject orderObject,
            final String searchValue, final MedicineDTO medicineDTO) {
        return converter.convertToDtoPaginationObject(
                dao.selectAllWithParametersByMedicine(pagination, orderObject, searchValue,
                        medicineConverter.convertToEntity(medicineDTO)));
    }
}
