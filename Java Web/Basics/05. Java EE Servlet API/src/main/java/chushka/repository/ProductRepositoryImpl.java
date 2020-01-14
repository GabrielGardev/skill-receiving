package chushka.repository;

import chushka.domain.entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private EntityManager entityManager;

    public ProductRepositoryImpl() {
        this.entityManager = Persistence
                .createEntityManagerFactory("chushka")
                .createEntityManager();
    }

    @Override
    public Product save(Product entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();

        return entity;
    }

    @Override
    public Product findById(String id) {
        entityManager.getTransaction().begin();
        Product product = entityManager.createQuery("SELECT p FROM Product p WHERE p.id = :id", Product.class)
                .setParameter("id", id)
                .getSingleResult();
        entityManager.getTransaction().commit();
        return product;
    }

    @Override
    public List<Product> findAll() {
        entityManager.getTransaction().begin();
        List<Product> resultList = entityManager
                .createQuery("SELECT p FROM Product p", Product.class)
                .getResultList();
        entityManager.getTransaction().commit();

        return resultList;
    }

    @Override
    public Product findByName(String name) {

        entityManager.getTransaction().begin();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = cb.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);

        criteriaQuery.select(root).where(cb.equal(root.get("name"), name));

        Product product = entityManager.createQuery(criteriaQuery).getSingleResult();

        entityManager.getTransaction().commit();

        return product;
    }
}
