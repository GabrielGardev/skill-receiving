package metube.repository;

import metube.domain.entities.User;

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
    public User findById(String id) {
        entityManager.getTransaction().begin();
        User user = entityManager.createQuery("SELECT u FROM User u WHERE u.id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
        entityManager.getTransaction().commit();

        return user;
    }

    @Override
    public List<User> findAll() {
        entityManager.getTransaction().begin();
        List<User> resultList = entityManager.createQuery("SELECT u FROM User u", User.class)
                .getResultList();
        entityManager.getTransaction().commit();

        return resultList;
    }

    @Override
    public Long size() {
        entityManager.getTransaction().begin();
        Long result = entityManager.createQuery("SELECT count(u) FROM User u", Long.class)
                .getSingleResult();
        entityManager.getTransaction().commit();

        return result;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        entityManager.getTransaction().begin();
        User user;
        try {
            user = entityManager
                    .createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :pass", User.class)
                    .setParameter("username", username)
                    .setParameter("pass", password)
                    .getSingleResult();
        }catch (Exception e){
            return null;
        }finally {
            entityManager.getTransaction().commit();
        }

        return user;
    }

    @Override
    public User findByUsername(String username) {
        entityManager.getTransaction().begin();
        User user;
        try {
            user = entityManager
                    .createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                    .setParameter("username", username)
                    .getSingleResult();
        }catch (Exception e){
            return null;
        }finally {
            entityManager.getTransaction().commit();
        }

        return user;
    }


}
