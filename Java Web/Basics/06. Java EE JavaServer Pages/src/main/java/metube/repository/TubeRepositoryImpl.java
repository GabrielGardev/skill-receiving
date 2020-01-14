package metube.repository;

import metube.domain.entities.Tube;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class TubeRepositoryImpl implements TubeRepository {

    private EntityManager entityManager;

    public TubeRepositoryImpl() {
        this.entityManager = Persistence
                .createEntityManagerFactory("metube")
                .createEntityManager();
    }

    @Override
    public Tube save(Tube entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();

        return entity;
    }

    @Override
    public Optional<Tube> findById(String id) {
        try {
            Optional<Tube> tube = Optional.of(entityManager
                    .createQuery("SELECT t FROM Tube t WHERE t.id = ?1", Tube.class)
                    .setParameter(1, id)
                    .getSingleResult());

            return tube;
        }catch (NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public List<Tube> findAll() {
        return entityManager
                .createQuery("SELECT t FROM Tube t", Tube.class)
                .getResultList();
    }

    @Override
    public Optional<Tube> findByName(String name) {
        try {
            Optional<Tube> tube = Optional.of(entityManager
                    .createQuery("SELECT t FROM Tube t WHERE t.name = ?1", Tube.class)
                    .setParameter(1, name)
                    .getSingleResult());

            return tube;
        }catch (NoResultException e){
            return Optional.empty();
        }
    }
}
