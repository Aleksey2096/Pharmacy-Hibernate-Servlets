package by.academy.pharmacy.dao;

import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.entity.ProducerEntity;

public interface ProducerDAO extends DAO<ProducerEntity, Long> {
    PaginationObject<ProducerEntity> selectAllWithParameters(
            final PaginationObject<ProducerEntity> pagination,
            final OrderObject orderObject,
            final String searchValue);
}
