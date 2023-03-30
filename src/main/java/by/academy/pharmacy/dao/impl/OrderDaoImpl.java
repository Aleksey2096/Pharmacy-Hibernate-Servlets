package by.academy.pharmacy.dao.impl;

import by.academy.pharmacy.dao.OrderDAO;
import by.academy.pharmacy.entity.OrderEntity;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.OrderType;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.entity.UserEntity;
import by.academy.pharmacy.service.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

import static by.academy.pharmacy.entity.Constant.AMOUNT;
import static by.academy.pharmacy.entity.Constant.CONTACT_PHONE;
import static by.academy.pharmacy.entity.Constant.DELIVERY_ADDRESS;
import static by.academy.pharmacy.entity.Constant.ID;
import static by.academy.pharmacy.entity.Constant.LOCAL_DATE_TIME;
import static by.academy.pharmacy.entity.Constant.PAYMENT_CARD_NUMBER;
import static by.academy.pharmacy.entity.Constant.PRICE;
import static by.academy.pharmacy.entity.Constant.USER_ENTITY;

public final class OrderDaoImpl implements OrderDAO {
    private final EntityManager entityManager
            = HibernateUtil.getEntityManager();

    @Override
    public Class<OrderEntity> getEntityClass() {
        return OrderEntity.class;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Predicate createCommonPredicate(final Root<OrderEntity> root,
                                           final String searchValue) {
        return createOrPredicate(searchValue, List.of(
                root.get(ID).as(String.class),
                root.get(LOCAL_DATE_TIME).as(String.class),
                root.get(AMOUNT).as(String.class),
                root.get(PRICE).as(String.class),
                root.get(PAYMENT_CARD_NUMBER).as(String.class),
                root.get(CONTACT_PHONE),
                root.get(DELIVERY_ADDRESS)
        ));
    }

    @Override
    public PaginationObject<OrderEntity> selectAllWithParameters(
            final PaginationObject<OrderEntity> pagination,
            final OrderObject orderObject,
            final String searchValue) {
        return selectAllWithParameters(pagination, orderObject, ID,
                searchValue);
    }

    @Override
    public PaginationObject<OrderEntity> selectAllWithParametersByUser(
            final PaginationObject<OrderEntity> pagination,
            final OrderObject orderObject,
            final String searchValue, final UserEntity userEntity) {
        entityManager.getTransaction().begin();
        entityManager.clear();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<OrderEntity> cq = cb.createQuery(OrderEntity.class);
        Root<OrderEntity> root = cq.from(OrderEntity.class);
        Predicate mainPredicate;
        Predicate userPredicate = cb.equal(root.get(USER_ENTITY), userEntity);
        if (searchValue != null && !searchValue.isBlank()) {
            mainPredicate = cb.and(createCommonPredicate(root, searchValue),
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
        TypedQuery<OrderEntity> typedQuery = entityManager.createQuery(cq);
        typedQuery
                .setFirstResult((pagination.getCurrentPage() - 1)
                        * pagination.getRecordsPerPage());
        typedQuery.setMaxResults(pagination.getRecordsPerPage());
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        countQuery.select(cb.count(countQuery.from(OrderEntity.class)));
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
