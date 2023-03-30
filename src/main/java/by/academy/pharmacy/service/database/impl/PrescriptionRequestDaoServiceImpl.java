package by.academy.pharmacy.service.database.impl;

import by.academy.pharmacy.dao.DAO;
import by.academy.pharmacy.dao.PrescriptionRequestDAO;
import by.academy.pharmacy.dao.impl.PrescriptionRequestDaoImpl;
import by.academy.pharmacy.dto.PrescriptionRequestDTO;
import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.entity.PrescriptionRequestEntity;
import by.academy.pharmacy.entity.UserEntity;
import by.academy.pharmacy.service.database.PrescriptionRequestDaoService;
import by.academy.pharmacy.service.mapping.Converter;
import by.academy.pharmacy.service.mapping.impl.PrescriptionRequestConverter;
import by.academy.pharmacy.service.mapping.impl.UserConverter;

public final class PrescriptionRequestDaoServiceImpl
        implements PrescriptionRequestDaoService {
    private final PrescriptionRequestDAO dao = new PrescriptionRequestDaoImpl();
    private final Converter<PrescriptionRequestEntity, PrescriptionRequestDTO>
            converter = new PrescriptionRequestConverter();
    private final Converter<UserEntity, UserDTO> userConverter
            = new UserConverter();

    @Override
    public DAO<PrescriptionRequestEntity, Long> getDAO() {
        return dao;
    }

    @Override
    public Converter<PrescriptionRequestEntity, PrescriptionRequestDTO> getConverter() {
        return converter;
    }

    @Override
    public PaginationObject<PrescriptionRequestDTO> readAllWithParameters(
            final PaginationObject<PrescriptionRequestEntity> paginationObject,
            final OrderObject orderObject, final String searchValue) {
        return converter.convertToDtoPaginationObject(
                dao.selectAllWithParameters(paginationObject, orderObject,
                        searchValue));
    }

    @Override
    public PaginationObject<PrescriptionRequestDTO> readAllUnprocessedWithParameters(
            final PaginationObject<PrescriptionRequestEntity> paginationObject,
            final OrderObject orderObject, final String searchValue) {
        return converter.convertToDtoPaginationObject(
                dao.selectAllUnprocessedWithParameters(paginationObject,
                        orderObject, searchValue));
    }

    @Override
    public PaginationObject<PrescriptionRequestDTO> readAllWithParametersByUser(
            final PaginationObject<PrescriptionRequestEntity> pagination,
            final OrderObject orderObject, final String searchValue,
            final UserDTO userDTO) {
        return converter.convertToDtoPaginationObject(
                dao.selectAllWithParametersByUser(pagination,
                        orderObject, searchValue,
                        userConverter.convertToEntity(userDTO)));
    }
}
