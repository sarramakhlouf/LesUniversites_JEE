package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.Universite;
import util.JPAutil;

public class UniversiteDaoImpl implements IUniversiteDao {
    
    private EntityManager entityManager = JPAutil.getEntityManager("TP5_JEE");

    @Override
    public Universite save(Universite u) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(u);
        tx.commit();
        return u;
    }

    @Override
    public List<Universite> universitesParMC(String mc) {
        return entityManager.createQuery("SELECT u FROM Universite u WHERE u.nomUni LIKE :mc", Universite.class)
                .setParameter("mc", "%" + mc + "%")
                .getResultList();
    }

    @Override
    public Universite getUniversite(int id) {
        return entityManager.find(Universite.class, id);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Universite updated = entityManager.merge(u);
        tx.commit();
        return updated;
    }

    @Override
    public void deleteUniversite(int id) {
        Universite universite = entityManager.find(Universite.class, id);
        if (universite != null) {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            entityManager.remove(universite);
            tx.commit();
        }
    }
}
