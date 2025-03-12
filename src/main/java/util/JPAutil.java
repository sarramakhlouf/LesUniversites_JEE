package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAutil {
    private static EntityManagerFactory emf;

    public static EntityManager getEntityManager(String persistenceUnitName) {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        }
        return emf.createEntityManager();
    }

    public static void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
