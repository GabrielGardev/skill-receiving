package exam.repository;


import exam.domain.entities.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private final EntityManager entityManager;

    @Inject
    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User save(User entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();

        return entity;
    }

    @Override
    public List<User> findAll() {
        entityManager.getTransaction().begin();
        List<User> users = entityManager
                .createQuery("SELECT u FROM User u ", User.class)
                .getResultList();
        entityManager.getTransaction().commit();

        return users;
    }

    @Override
    public User findById(String id) {
        entityManager.getTransaction().begin();
        User user = entityManager
                .createQuery("SELECT u FROM User u WHERE u.id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
        entityManager.getTransaction().commit();

        return user;
    }

    @Override
    public User findByUsername(String username) {
        entityManager.getTransaction().begin();
        try {
            User user = entityManager
                    .createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                    .setParameter("username", username)
                    .getSingleResult();
            entityManager.getTransaction().commit();

            return user;
        } catch (Exception e) {
            entityManager.getTransaction().commit();
            return null;
        }
    }
}
