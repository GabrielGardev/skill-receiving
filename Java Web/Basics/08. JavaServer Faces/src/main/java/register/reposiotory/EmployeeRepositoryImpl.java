package register.reposiotory;

import register.domain.entities.Employee;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final EntityManager entityManager;

    @Inject
    public EmployeeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Employee save(Employee entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();

        return entity;
    }

    @Override
    public Employee findById(String id) {
        entityManager.getTransaction().begin();
        Employee employee = entityManager.createQuery("SELECT u FROM Employee u WHERE u.id = :id", Employee.class)
                .setParameter("id", id)
                .getSingleResult();
        entityManager.getTransaction().commit();

        return employee;
    }

    @Override
    public List<Employee> findAll() {
        entityManager.getTransaction().begin();
        List<Employee> resultList = entityManager.createQuery("SELECT u FROM Employee u", Employee.class)
                .getResultList();
        entityManager.getTransaction().commit();

        return resultList;
    }

    @Override
    public Long size() {
        entityManager.getTransaction().begin();
        Long result = entityManager.createQuery("SELECT count(u) FROM Employee u", Long.class)
                .getSingleResult();
        entityManager.getTransaction().commit();

        return result;
    }
    @Override
    public void deleteById(String id) {

        this.entityManager.getTransaction().begin();

        this.entityManager.createQuery("DELETE FROM Employee e WHERE e.id =:id")
                .setParameter("id", id).executeUpdate();

        this.entityManager.getTransaction().commit();
    }

    @Override
    public Long getCount() {
        this.entityManager.getTransaction().begin();

        Long count = this.entityManager.createQuery("SELECT count(e) FROM Employee e", Long.class)
                .getSingleResult();

        this.entityManager.getTransaction().commit();

        return count;
    }

    @Override
    public BigDecimal getTotalMoney() {

        this.entityManager.getTransaction().begin();

        BigDecimal totalMoney = this.entityManager
                .createQuery("SELECT sum(e.salary) FROM Employee e", BigDecimal.class)
                .getSingleResult();

        this.entityManager.getTransaction().commit();

        return totalMoney;
    }
}
