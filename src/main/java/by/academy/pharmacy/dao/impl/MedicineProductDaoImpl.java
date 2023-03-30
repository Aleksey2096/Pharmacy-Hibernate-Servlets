package by.academy.pharmacy.dao.impl;

import by.academy.pharmacy.dao.MedicineProductDAO;
import by.academy.pharmacy.entity.MedicineEntity;
import by.academy.pharmacy.entity.MedicineProductEntity;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.OrderType;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.service.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

import static by.academy.pharmacy.entity.Constant.AMOUNT;
import static by.academy.pharmacy.entity.Constant.DOSAGE;
import static by.academy.pharmacy.entity.Constant.FORM;
import static by.academy.pharmacy.entity.Constant.ID;
import static by.academy.pharmacy.entity.Constant.MEDICINE_ENTITY;
import static by.academy.pharmacy.entity.Constant.PRICE;

public final class MedicineProductDaoImpl implements MedicineProductDAO {
    private final EntityManager entityManager
            = HibernateUtil.getEntityManager();

    @Override
    public Class<MedicineProductEntity> getEntityClass() {
        return MedicineProductEntity.class;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Predicate createCommonPredicate(
            final Root<MedicineProductEntity> root,
            final String searchValue) {
        return createOrPredicate(searchValue, List.of(
                root.get(ID).as(String.class),
                root.get(DOSAGE).as(String.class),
                root.get(FORM).as(String.class),
                root.get(PRICE).as(String.class),
                root.get(AMOUNT).as(String.class)
        ));
    }

    @Override
    public PaginationObject<MedicineProductEntity> selectAllWithParameters(
            final PaginationObject<MedicineProductEntity> pagination,
            final OrderObject orderObject,
            final String searchValue) {
        return selectAllWithParameters(pagination, orderObject, ID,
                searchValue);
    }

    @Override
    public PaginationObject<MedicineProductEntity> selectAllWithParametersByMedicine(
            final PaginationObject<MedicineProductEntity> pagination,
            final OrderObject orderObject,
            final String searchValue, final MedicineEntity medicineEntity) {
        entityManager.getTransaction().begin();
        entityManager.clear();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<MedicineProductEntity> cq = cb.createQuery(
                MedicineProductEntity.class);
        Root<MedicineProductEntity> root = cq.from(MedicineProductEntity.class);
        Predicate mainPredicate;
        Predicate medicinePredicate = cb.equal(root.get(MEDICINE_ENTITY),
                medicineEntity);
        if (searchValue != null && !searchValue.isBlank()) {
            mainPredicate = cb.and(createCommonPredicate(root, searchValue),
                    medicinePredicate);
        } else {
            mainPredicate = medicinePredicate;
        }
        cq.select(root).where(mainPredicate);
        if (orderObject.getOrderField() == null) {
            orderObject.setOrderField(ID);
        }
        if (OrderType.ASC.equals(orderObject.getOrderType())) {
            cq.orderBy(cb.asc(root.get(orderObject.getOrderField())));
        } else {
            cq.orderBy(cb.desc(root.get(orderObject.getOrderField())));
        }
        TypedQuery<MedicineProductEntity> typedQuery
                = entityManager.createQuery(cq);
        typedQuery
                .setFirstResult((pagination.getCurrentPage() - 1)
                        * pagination.getRecordsPerPage());
        typedQuery.setMaxResults(pagination.getRecordsPerPage());
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        countQuery.select(
                cb.count(countQuery.from(MedicineProductEntity.class)));
        countQuery.where(mainPredicate);
        pagination.setPagesNum(
                countNumberOfPages(pagination.getRecordsPerPage(),
                        entityManager.createQuery(countQuery)
                                .getSingleResult()));
        pagination.setRecords(typedQuery.getResultList());
        entityManager.getTransaction().commit();
        return pagination;
    }
}
