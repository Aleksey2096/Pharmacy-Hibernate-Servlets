package by.academy.pharmacy.service.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.Properties;

import static by.academy.pharmacy.entity.Constant.PERSISTENCE_UNIT_NAME;
import static by.academy.pharmacy.entity.Constant.PERSISTENCE_UNIT_PROPERTIES;

public final class HibernateUtil {
    /**
     * jpa object, which works with database.
     */
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY;

    static {
        Properties properties = new Properties();
        try {
            properties.load(HibernateUtil.class.getClassLoader()
                    .getResourceAsStream(PERSISTENCE_UNIT_PROPERTIES));
        } catch (IOException newE) {
            newE.printStackTrace();
        }
        ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory(
                properties.getProperty(PERSISTENCE_UNIT_NAME));
    }

    /**
     * private default constructor.
     */
    private HibernateUtil() {
    }

    /**
     * @return new application-managed EntityManager.
     */
    public static EntityManager getEntityManager() {
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }

    /**
     * closes the factory, releasing any resources that it holds.
     */
    public static void close() {
        ENTITY_MANAGER_FACTORY.close();
    }
}
