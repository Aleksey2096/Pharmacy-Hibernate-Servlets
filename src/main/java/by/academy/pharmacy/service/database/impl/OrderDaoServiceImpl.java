package by.academy.pharmacy.service.database.impl;

import by.academy.pharmacy.dao.DAO;
import by.academy.pharmacy.dao.OrderDAO;
import by.academy.pharmacy.dao.impl.OrderDaoImpl;
import by.academy.pharmacy.dto.OrderDTO;
import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.entity.OrderEntity;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.entity.UserEntity;
import by.academy.pharmacy.service.database.OrderDaoService;
import by.academy.pharmacy.service.mapping.Converter;
import by.academy.pharmacy.service.mapping.impl.OrderConverter;
import by.academy.pharmacy.service.mapping.impl.UserConverter;

public final class OrderDaoServiceImpl implements OrderDaoService {
    private final OrderDAO dao = new OrderDaoImpl();
    private final Converter<OrderEntity, OrderDTO> converter
            = new OrderConverter();
    private final Converter<UserEntity, UserDTO> userConverter
            = new UserConverter();

    @Override
    public DAO<OrderEntity, Long> getDAO() {
        return dao;
    }

    @Override
    public Converter<OrderEntity, OrderDTO> getConverter() {
        return converter;
    }

    @Override
    public PaginationObject<OrderDTO> readAllWithParameters(
            final PaginationObject<OrderEntity> paginationObject,
            final OrderObject orderObject,
            final String searchValue) {
        return converter.convertToDtoPaginationObject(
                dao.selectAllWithParameters(paginationObject, orderObject,
                        searchValue));
    }

    @Override
    public PaginationObject<OrderDTO> readAllWithParametersByUser(
            final PaginationObject<OrderEntity> pagination,
            final OrderObject orderObject,
            final String searchValue, final UserDTO userDTO) {
        return converter.convertToDtoPaginationObject(
                dao.selectAllWithParametersByUser(pagination,
                        orderObject, searchValue,
                        userConverter.convertToEntity(userDTO)));
    }
}
