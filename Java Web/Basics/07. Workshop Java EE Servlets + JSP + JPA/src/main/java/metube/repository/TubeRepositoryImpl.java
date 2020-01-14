package metube.repository;

import metube.domain.entities.Tube;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class TubeRepositoryImpl implements TubeRepository {
    private final EntityManager entityManager;

    @Inject
    public TubeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Tube save(Tube entity) {
        inTransaction(entityManager,
                () -> entityManager.persist(entity));
        return entity;
    }

    @Override
    public Tube findById(String id) {
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        Tube tube = entityManager.createQuery("SELECT t FROM Tube t WHERE t.id = :id", Tube.class)
                .setParameter("id", id)
                .getSingleResult();
        entityManager.getTransaction().commit();

        return tube;
    }

    @Override
    public List<Tube> findAll() {
        final List[] result = new List[]{new ArrayList<Tube>()};
        inTransaction(entityManager,
                () -> result[0] = entityManager
                        .createQuery("SELECT t FROM Tube t", Tube.class)
                        .getResultList());
        return result[0];
    }

    @Override
    public Long size() {
        final long[] result = new long[1];
        inTransaction(entityManager,
                () -> result[0] = entityManager
                        .createQuery("SELECT count(t) FROM Tube t", long.class)
                        .getSingleResult());
        return result[0];
    }

    private static void inTransaction(EntityManager entityManager, Runnable runnable) {
        entityManager.getTransaction().begin();
        runnable.run();
        entityManager.getTransaction().commit();
    }

    @Override
    public Tube update(Tube tube) {
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(tube);
        this.entityManager.getTransaction().commit();

        return tube;
    }
}
