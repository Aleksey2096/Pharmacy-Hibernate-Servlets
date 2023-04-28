package by.academy.pharmacy.dao.impl;

import by.academy.pharmacy.dao.MedicineDAO;
import by.academy.pharmacy.entity.MedicineEntity;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;

import javax.persistence.EntityManager;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

import static by.academy.pharmacy.entity.Constant.APPROVAL_DATE;
import static by.academy.pharmacy.entity.Constant.ID;
import static by.academy.pharmacy.entity.Constant.IS_NONPRESCRIPTION;
import static by.academy.pharmacy.entity.Constant.TITLE;

public final class MedicineDaoImpl implements MedicineDAO {
    @Override
    public Class<MedicineEntity> getEntityClass() {
        return MedicineEntity.class;
    }

    @Override
    public Predicate createCommonPredicate(final Root<MedicineEntity> root,
                                           final String searchValue,
                                           final EntityManager entityManager) {
        return createOrPredicate(searchValue, List.of(
                root.get(ID).as(String.class),
                root.get(TITLE),
                root.get(IS_NONPRESCRIPTION).as(String.class),
                root.get(APPROVAL_DATE).as(String.class)
        ), entityManager);
    }

    @Override
    public PaginationObject<MedicineEntity> selectAllWithParameters(
            final PaginationObject<MedicineEntity> pagination, final OrderObject orderObject,
            final String searchValue) {
        return selectAllWithParameters(pagination, orderObject, ID, searchValue);
    }
}
