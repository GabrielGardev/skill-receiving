package exam.repository;

import exam.domain.entities.Hero;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class HeroRepositoryImpl implements HeroRepository {

    private final EntityManager entityManager;

    @Inject
    public HeroRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Hero save(Hero entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();

        return entity;
    }

    @Override
    public List<Hero> findAll() {
        entityManager.getTransaction().begin();
        List<Hero> heroes = entityManager
                .createQuery("SELECT u FROM Hero u ORDER BY u.level desc", Hero.class)
                .getResultList();
        entityManager.getTransaction().commit();

        return heroes;
    }

    @Override
    public Hero findById(String id) {
        entityManager.getTransaction().begin();
        Hero hero = entityManager
                .createQuery("SELECT u FROM Hero u WHERE u.id = :id", Hero.class)
                .setParameter("id", id)
                .getSingleResult();
        entityManager.getTransaction().commit();

        return hero;
    }

    @Override
    public Hero findByName(String name) {
        entityManager.getTransaction().begin();
        Hero hero = entityManager
                .createQuery("SELECT u FROM Hero u WHERE u.name = :name", Hero.class)
                .setParameter("name", name)
                .getSingleResult();
        entityManager.getTransaction().commit();

        return hero;
    }

    @Override
    public void deleteById(String id) {
        this.entityManager.getTransaction().begin();

        this.entityManager.createQuery("DELETE FROM Hero h WHERE h.id =:id")
                .setParameter("id", id).executeUpdate();

        this.entityManager.getTransaction().commit();
    }
}
