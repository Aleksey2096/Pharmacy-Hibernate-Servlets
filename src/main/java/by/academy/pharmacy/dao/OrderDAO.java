package by.academy.pharmacy.dao;

import by.academy.pharmacy.entity.OrderEntity;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.entity.UserEntity;

public interface OrderDAO extends DAO<OrderEntity, Long> {
    PaginationObject<OrderEntity> selectAllWithParameters(
            final PaginationObject<OrderEntity> pagination,
            final OrderObject orderObject,
            final String searchValue);

    PaginationObject<OrderEntity> selectAllWithParametersByUser(
            final PaginationObject<OrderEntity> pagination,
            final OrderObject orderObject,
            final String searchValue, final UserEntity userEntity);
}
