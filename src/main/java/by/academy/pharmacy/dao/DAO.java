package by.academy.pharmacy.dao;

import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.OrderType;
import by.academy.pharmacy.entity.PaginationObject;

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

    EntityManager getEntityManager();

    Predicate createCommonPredicate(Root<E> root, String searchValue);

    default E insert(final E entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(entity);
        getEntityManager().getTransaction().commit();
        return entity;
    }

    default E selectById(final K id) {
        getEntityManager().getTransaction().begin();
        getEntityManager().clear();
        E entity = getEntityManager().find(getEntityClass(), id);
        getEntityManager().getTransaction().commit();
        return entity;
    }

    default void update(final E entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().merge(entity);
        getEntityManager().getTransaction().commit();
    }

    default void deleteById(final K id) {
        getEntityManager().getTransaction().begin();
        getEntityManager().remove(
                getEntityManager().find(getEntityClass(), id));
        getEntityManager().getTransaction().commit();
    }

    @SuppressWarnings(UNCHECKED)
    default List<E> selectAll() {
        getEntityManager().getTransaction().begin();
        getEntityManager().clear();
        List<E> entities = getEntityManager()
                .createQuery(String.format(FROM_HIBERNATE_CLASS,
                        getEntityClass().getSimpleName()))
                .getResultList();
        getEntityManager().getTransaction().commit();
        return entities;
    }

    /**
     * @param recordsPerPage number of records displayed on single page.
     * @param rowsNum        common quantity of rows found in database.
     * @return number of pages.
     */
    default Integer countNumberOfPages(final Integer recordsPerPage,
                                       final Long rowsNum) {
        if (rowsNum % recordsPerPage == 0) {
            return (int) (rowsNum / recordsPerPage);
        } else {
            return (int) (rowsNum / recordsPerPage) + 1;
        }
    }

    default Predicate createOrPredicate(String searchValue,
                                        List<Expression<String>> expressions) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        Predicate[] predicates = new Predicate[expressions.size()];
        for (int i = 0; i < predicates.length; ++i) {
            predicates[i] = cb.like(expressions.get(i),
                    PERCENTAGE_SYMBOL + searchValue + PERCENTAGE_SYMBOL);
        }
        return cb.or(predicates);
    }

    default PaginationObject<E> selectAllWithParameters(
            final PaginationObject<E> pagination,
            final OrderObject orderObject, final String defaultOrderField,
            final String searchValue) {
        getEntityManager().getTransaction().begin();
        getEntityManager().clear();
        Long count = countNumberOfRecords(searchValue);
        CriteriaQuery<E> cq = createSelectQuery(orderObject, defaultOrderField,
                searchValue);
        TypedQuery<E> typedQuery = getEntityManager().createQuery(cq);
        typedQuery
                .setFirstResult((pagination.getCurrentPage() - 1)
                        * pagination.getRecordsPerPage());
        typedQuery.setMaxResults(pagination.getRecordsPerPage());
        pagination.setPagesNum(
                countNumberOfPages(pagination.getRecordsPerPage(), count));
        pagination.setRecords(typedQuery.getResultList());
        getEntityManager().getTransaction().commit();
        return pagination;
    }

    default Long countNumberOfRecords(final String searchValue) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<E> root = countQuery.from(getEntityClass());
        countQuery.select(cb.count(root));
        if (searchValue != null && !searchValue.isBlank()) {
            countQuery.where(createCommonPredicate(root, searchValue));
        }
        return getEntityManager().createQuery(countQuery).getSingleResult();
    }

    default CriteriaQuery<E> createSelectQuery(final OrderObject orderObject,
                                               final String defaultOrderField,
                                               final String searchValue) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<E> cq = cb.createQuery(getEntityClass());
        Root<E> root = cq.from(getEntityClass());
        if (searchValue != null && !searchValue.isBlank()) {
            cq.select(root).where(createCommonPredicate(root, searchValue));
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
