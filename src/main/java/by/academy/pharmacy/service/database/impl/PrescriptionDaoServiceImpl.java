package by.academy.pharmacy.service.database.impl;

import by.academy.pharmacy.dao.DAO;
import by.academy.pharmacy.dao.PrescriptionDAO;
import by.academy.pharmacy.dao.impl.PrescriptionDaoImpl;
import by.academy.pharmacy.dto.PrescriptionDTO;
import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.entity.PrescriptionEntity;
import by.academy.pharmacy.entity.UserEntity;
import by.academy.pharmacy.service.database.PrescriptionDaoService;
import by.academy.pharmacy.service.mapping.Converter;
import by.academy.pharmacy.service.mapping.impl.PrescriptionConverter;
import by.academy.pharmacy.service.mapping.impl.UserConverter;

public final class PrescriptionDaoServiceImpl
        implements PrescriptionDaoService {
    private final PrescriptionDAO dao = new PrescriptionDaoImpl();
    private final Converter<PrescriptionEntity, PrescriptionDTO> converter
            = new PrescriptionConverter();
    private final Converter<UserEntity, UserDTO> userConverter
            = new UserConverter();

    @Override
    public DAO<PrescriptionEntity, Long> getDAO() {
        return dao;
    }

    @Override
    public Converter<PrescriptionEntity, PrescriptionDTO> getConverter() {
        return converter;
    }

    @Override
    public PaginationObject<PrescriptionDTO> readAllWithParametersByUser(
            final PaginationObject<PrescriptionEntity> pagination,
            final OrderObject orderObject,
            final String searchValue, final UserDTO userDTO) {
        return converter.convertToDtoPaginationObject(
                dao.selectAllWithParametersByUser(pagination,
                        orderObject, searchValue,
                        userConverter.convertToEntity(userDTO)));
    }
}
