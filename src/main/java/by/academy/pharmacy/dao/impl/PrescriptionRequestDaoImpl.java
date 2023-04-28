package by.academy.pharmacy.dao.impl;

import by.academy.pharmacy.dao.PrescriptionRequestDAO;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.OrderType;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.entity.PrescriptionRequestEntity;
import by.academy.pharmacy.entity.PrescriptionRequestStatus;
import by.academy.pharmacy.entity.UserEntity;
import by.academy.pharmacy.service.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

import static by.academy.pharmacy.entity.Constant.ID;
import static by.academy.pharmacy.entity.Constant.PRESCRIPTION_REQUEST_STATUS;
import static by.academy.pharmacy.entity.Constant.UPLOAD_DATE_TIME;
import static by.academy.pharmacy.entity.Constant.USER_ENTITY;

public final class PrescriptionRequestDaoImpl implements PrescriptionRequestDAO {
    @Override
    public Class<PrescriptionRequestEntity> getEntityClass() {
        return PrescriptionRequestEntity.class;
    }

    @Override
    public Predicate createCommonPredicate(final Root<PrescriptionRequestEntity> root,
                                           final String searchValue,
                                           final EntityManager entityManager) {
        return createOrPredicate(searchValue, List.of(
                root.get(ID).as(String.class),
                root.get(UPLOAD_DATE_TIME).as(String.class),
                root.get(PRESCRIPTION_REQUEST_STATUS).as(String.class)
        ), entityManager);
    }

    @Override
    public PaginationObject<PrescriptionRequestEntity> selectAllWithParameters(
            final PaginationObject<PrescriptionRequestEntity> pagination,
            final OrderObject orderObject, final String searchValue) {
        return selectAllWithParameters(pagination, orderObject, ID, searchValue);
    }

    @Override
    public PaginationObject<PrescriptionRequestEntity> selectAllUnprocessedWithParameters(
            final PaginationObject<PrescriptionRequestEntity> pagination,
            final OrderObject orderObject, final String searchValue) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PrescriptionRequestEntity> cq = cb.createQuery(
                PrescriptionRequestEntity.class);
        Root<PrescriptionRequestEntity> root = cq.from(PrescriptionRequestEntity.class);
        Predicate mainPredicate;
        Predicate statusPredicate = cb.equal(root.get(PRESCRIPTION_REQUEST_STATUS),
                PrescriptionRequestStatus.UNPROCESSED);
        if (searchValue != null && !searchValue.isBlank()) {
            mainPredicate = cb.and(createCommonPredicate(root, searchValue, entityManager),
                    statusPredicate);
        } else {
            mainPredicate = statusPredicate;
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
        TypedQuery<PrescriptionRequestEntity> typedQuery = entityManager.createQuery(cq);
        typedQuery
                .setFirstResult((pagination.getCurrentPage() - 1) * pagination.getRecordsPerPage());
        typedQuery.setMaxResults(pagination.getRecordsPerPage());
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        countQuery.select(cb.count(countQuery.from(PrescriptionRequestEntity.class)));
        countQuery.where(mainPredicate);
        pagination.setPagesNum(countNumberOfPages(pagination.getRecordsPerPage(),
                entityManager.createQuery(countQuery).getSingleResult()));
        pagination.setRecords(typedQuery.getResultList());
        entityManager.getTransaction().commit();
        entityManager.close();
        return pagination;
    }

    @Override
    public PaginationObject<PrescriptionRequestEntity> selectAllWithParametersByUser(
            final PaginationObject<PrescriptionRequestEntity> pagination,
            final OrderObject orderObject, final String searchValue, final UserEntity userEntity) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PrescriptionRequestEntity> cq = cb.createQuery(
                PrescriptionRequestEntity.class);
        Root<PrescriptionRequestEntity> root = cq.from(PrescriptionRequestEntity.class);
        Predicate mainPredicate;
        Predicate userPredicate = cb.equal(root.get(USER_ENTITY), userEntity);
        if (searchValue != null && !searchValue.isBlank()) {
            mainPredicate = cb.and(createCommonPredicate(root, searchValue, entityManager),
                    userPredicate);
        } else {
            mainPredicate = userPredicate;
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
        TypedQuery<PrescriptionRequestEntity> typedQuery = entityManager.createQuery(cq);
        typedQuery
                .setFirstResult((pagination.getCurrentPage() - 1) * pagination.getRecordsPerPage());
        typedQuery.setMaxResults(pagination.getRecordsPerPage());
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        countQuery.select(cb.count(countQuery.from(PrescriptionRequestEntity.class)));
        countQuery.where(mainPredicate);
        pagination.setPagesNum(countNumberOfPages(pagination.getRecordsPerPage(),
                entityManager.createQuery(countQuery).getSingleResult()));
        pagination.setRecords(typedQuery.getResultList());
        entityManager.getTransaction().commit();
        entityManager.close();
        return pagination;
    }
}
