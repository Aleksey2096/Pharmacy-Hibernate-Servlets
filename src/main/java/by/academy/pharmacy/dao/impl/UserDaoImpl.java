package by.academy.pharmacy.dao.impl;

import by.academy.pharmacy.dao.UserDAO;
import by.academy.pharmacy.entity.MedicineProductEntity;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.entity.PrescriptionEntity;
import by.academy.pharmacy.entity.UserEntity;
import by.academy.pharmacy.service.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

import static by.academy.pharmacy.entity.Constant.DATE_JOINED;
import static by.academy.pharmacy.entity.Constant.HEALTH_CARE_CARD_NUMBER;
import static by.academy.pharmacy.entity.Constant.LOGIN;
import static by.academy.pharmacy.entity.Constant.ROLE;

public final class UserDaoImpl implements UserDAO {
    private final EntityManager entityManager
            = HibernateUtil.getEntityManager();

    @Override
    public Class<UserEntity> getEntityClass() {
        return UserEntity.class;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public UserEntity selectByLogin(final String login) {
        entityManager.getTransaction().begin();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> root = cq.from(UserEntity.class);
        cq.select(root).where(cb.equal(root.get(LOGIN), login));
        List<UserEntity> userEntities = entityManager.createQuery(cq)
                .getResultList();
        UserEntity userEntity = null;
        if (userEntities.size() > 0) {
            userEntity = userEntities.get(0);
        }
        entityManager.getTransaction().commit();
        return userEntity;
    }

    @Override
    public Predicate createCommonPredicate(final Root<UserEntity> root,
                                           final String searchValue) {
        return createOrPredicate(searchValue, List.of(
                root.get(HEALTH_CARE_CARD_NUMBER).as(String.class),
                root.get(LOGIN),
                root.get(ROLE).as(String.class),
                root.get(DATE_JOINED).as(String.class)
        ));
    }

    @Override
    public PaginationObject<UserEntity> selectAllWithParameters(
            final PaginationObject<UserEntity> pagination,
            final OrderObject orderObject,
            final String searchValue) {
        return selectAllWithParameters(pagination, orderObject,
                HEALTH_CARE_CARD_NUMBER,
                searchValue);
    }

    @Override
    public Set<MedicineProductEntity> selectCart(
            final Long healthCareCardNumber) {
        entityManager.getTransaction().begin();
        UserEntity userEntity = entityManager.find(UserEntity.class,
                healthCareCardNumber);
        Set<MedicineProductEntity> cart = userEntity.getCart();
        entityManager.getTransaction().commit();
        return cart;
    }

    @Override
    public Set<PrescriptionEntity> selectPrescriptions(
            final Long healthCareCardNumber) {
        entityManager.getTransaction().begin();
        UserEntity userEntity = entityManager.find(UserEntity.class,
                healthCareCardNumber);
        Set<PrescriptionEntity> prescriptions
                = userEntity.getPrescriptionEntities();
        entityManager.getTransaction().commit();
        return prescriptions;
    }
}
