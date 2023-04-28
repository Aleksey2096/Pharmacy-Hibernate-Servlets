package by.academy.pharmacy.dao.impl;

import by.academy.pharmacy.dao.ProducerDAO;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.entity.ProducerEntity;

import javax.persistence.EntityManager;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

import static by.academy.pharmacy.entity.Constant.COMPANY_NAME;
import static by.academy.pharmacy.entity.Constant.COUNTRY;
import static by.academy.pharmacy.entity.Constant.CREATION_DATE;
import static by.academy.pharmacy.entity.Constant.ID;

public final class ProducerDaoImpl implements ProducerDAO {
    @Override
    public Class<ProducerEntity> getEntityClass() {
        return ProducerEntity.class;
    }

    @Override
    public Predicate createCommonPredicate(final Root<ProducerEntity> root,
                                           final String searchValue,
                                           final EntityManager entityManager) {
        return createOrPredicate(searchValue, List.of(
                root.get(ID).as(String.class),
                root.get(COMPANY_NAME),
                root.get(COUNTRY).as(String.class),
                root.get(CREATION_DATE).as(String.class)
        ), entityManager);
    }

    @Override
    public PaginationObject<ProducerEntity> selectAllWithParameters(
            final PaginationObject<ProducerEntity> pagination, final OrderObject orderObject,
            final String searchValue) {
        return selectAllWithParameters(pagination, orderObject, ID, searchValue);
    }
}
