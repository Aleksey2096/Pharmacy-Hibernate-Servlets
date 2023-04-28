package by.academy.pharmacy.dao;

import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.OrderType;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.service.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

import static by.academy.pharmacy.entity.Constant.FROM_HIBERNATE_CLASS;
import static by.academy.pharmacy.entity.Constant.PERCENTAGE_SYMBOL;
import static by.academy.pharmacy.entity.Constant.UNCHECKED;

public interface DAO<E, K> {

    Class<E> getEntityClass();

    Predicate createCommonPredicate(Root<E> root, String searchValue, EntityManager entityManager);

    default E insert(final E entity) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return entity;
    }

    default E selectById(final K id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        E entity = entityManager.find(getEntityClass(), id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return entity;
    }

    default void update(final E entity) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    default void deleteById(final K id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(getEntityClass(), id));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @SuppressWarnings(UNCHECKED)
    default List<E> selectAll() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        List<E> entities = entityManager.createQuery(
                        String.format(FROM_HIBERNATE_CLASS, getEntityClass().getSimpleName()))
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return entities;
    }

    /**
     * @param recordsPerPage number of records displayed on single page.
     * @param rowsNum        common quantity of rows found in database.
     * @return number of pages.
     */
    default Integer countNumberOfPages(final Integer recordsPerPage, final Long rowsNum) {
        if (rowsNum % recordsPerPage == 0) {
            return (int) (rowsNum / recordsPerPage);
        } else {
            return (int) (rowsNum / recordsPerPage) + 1;
        }
    }

    default Predicate createOrPredicate(String searchValue, List<Expression<String>> expressions,
                                        final EntityManager entityManager) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        Predicate[] predicates = new Predicate[expressions.size()];
        for (int i = 0; i < predicates.length; ++i) {
            predicates[i] = cb.like(expressions.get(i),
                    PERCENTAGE_SYMBOL + searchValue + PERCENTAGE_SYMBOL);
        }
        return cb.or(predicates);
    }

    default PaginationObject<E> selectAllWithParameters(final PaginationObject<E> pagination,
                                                        final OrderObject orderObject,
                                                        final String defaultOrderField,
                                                        final String searchValue) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Long count = countNumberOfRecords(searchValue, entityManager);
        CriteriaQuery<E> cq = createSelectQuery(orderObject, defaultOrderField, searchValue,
                entityManager);
        TypedQuery<E> typedQuery = entityManager.createQuery(cq);
        typedQuery.setFirstResult(
                (pagination.getCurrentPage() - 1) * pagination.getRecordsPerPage());
        typedQuery.setMaxResults(pagination.getRecordsPerPage());
        pagination.setPagesNum(countNumberOfPages(pagination.getRecordsPerPage(), count));
        pagination.setRecords(typedQuery.getResultList());
        entityManager.getTransaction().commit();
        entityManager.close();
        return pagination;
    }

    default Long countNumberOfRecords(final String searchValue, final EntityManager entityManager) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<E> root = countQuery.from(getEntityClass());
        countQuery.select(cb.count(root));
        if (searchValue != null && !searchValue.isBlank()) {
            countQuery.where(createCommonPredicate(root, searchValue, entityManager));
        }
        return entityManager.createQuery(countQuery).getSingleResult();
    }

    default CriteriaQuery<E> createSelectQuery(final OrderObject orderObject,
                                               final String defaultOrderField,
                                               final String searchValue,
                                               final EntityManager entityManager) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<E> cq = cb.createQuery(getEntityClass());
        Root<E> root = cq.from(getEntityClass());
        if (searchValue != null && !searchValue.isBlank()) {
            cq.select(root).where(createCommonPredicate(root, searchValue, entityManager));
        } else {
            cq.select(root);
        }
        if (orderObject.getOrderField() == null) {
            orderObject.setOrderField(defaultOrderField);
        }
        if (OrderType.ASC.equals(orderObject.getOrderType())) {
            cq.orderBy(cb.asc(root.get(orderObject.getOrderField())));
        } else {
            cq.orderBy(cb.desc(root.get(orderObject.getOrderField())));
        }
        return cq;
    }
}
