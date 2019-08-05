import entities.*;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Engine implements Runnable {
    private final EntityManager entityManager;
    private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void run() {
        //02.
        //this.removeObjects();
        //03.
        //this.containsEmployee();
        //04.
        //this.employeesWithSalaryOver50000();
        //05.
        //this.employeesFromDepartment();
        //06.
        //this.addingANewAddressAndUpdatingEmployee();
        //07.
        //this.addressesWithEmployeeCount();
        //08.
        //this.getEmployeeWithProject();
        //09.
        //this.findLatest10Projects();
        //10.
        //this.increaseSalaries();
        //11.
        //this.removeTowns();
        //12.
        //this.findEmployeesByFirstName();
        //13.
        //this.employeesMaximumSalaries();
    }

    //02.
    private void removeObjects() {
        int len = 5;

        entityManager.getTransaction().begin();

        List<Town> towns = entityManager
                .createQuery("FROM Town WHERE length(name) > :len", Town.class)
                .setParameter("len", len)
                .getResultList();

        for (Town town : towns) {
            town.setName(town.getName().toLowerCase());

            entityManager.persist(town);
        }
        entityManager.getTransaction().commit();
    }

    //03.
    private void containsEmployee() {
        String name = null;
        try {
            name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        entityManager.getTransaction().begin();

        try {
            Employee employee = entityManager
                    .createQuery("FROM Employee WHERE concat(first_name, ' ', last_name) = :name", Employee.class)
                    .setParameter("name", name)
                    .getSingleResult();

            System.out.println("Yes");
        } catch (Exception e) {
            System.out.println("No");
        }
        entityManager.getTransaction().commit();
    }

    //04.
    private void employeesWithSalaryOver50000() {
        entityManager
                .createQuery("FROM Employee WHERE salary > 50000", Employee.class)
                .getResultList()
                .forEach(e -> System.out.println(e.getFirstName()));
    }

    //05.
    private void employeesFromDepartment() {
        entityManager
                .createQuery("FROM Employee as e " +
                        "WHERE e.department = 6 " +
                        "ORDER BY e.salary, e.id", Employee.class)
                .getResultStream()
                .forEach(e -> System.out.println(String.format("%s %s from %s - $%.2f",
                        e.getFirstName(),
                        e.getLastName(),
                        e.getDepartment().getName(),
                        e.getSalary())));
    }

    //06.
    private void addingANewAddressAndUpdatingEmployee() {
        String name = null;
        try {
            name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        entityManager.getTransaction().begin();

        Address address = new Address();
        address.setText("Vitoshka 15");
        entityManager.persist(address);
        try {
            Employee employee = entityManager
                    .createQuery("FROM Employee e WHERE e.lastName = :name", Employee.class)
                    .setParameter("name", name)
                    .getSingleResult();
            employee.setAddress(address);
            entityManager.persist(employee);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("There's more than one employee with that last name");
        }
    }

    //07.
    private void addressesWithEmployeeCount() {
        this.entityManager
                .createQuery("FROM Address as a ORDER BY size(employees) DESC, a.town.id ASC", Address.class)
                .setMaxResults(10)
                .getResultList()
                .forEach(a -> System.out.println(String.format("%s, %s - %s employees",
                        a.getText(),
                        a.getTown().getName(),
                        a.getEmployees().size())));
    }

    //08.
    private void getEmployeeWithProject() {
        int id = 0;
        try {
            id = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Employee employee = entityManager
                .createQuery("FROM Employee WHERE id = :id", Employee.class)
                .setParameter("id", id)
                .getSingleResult();

        System.out.println(String.format("%s %s - %s",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJobTitle()));

        Set<Project> projects = employee.getProjects();
        List<Project> projects1 = new ArrayList<>(projects);
        projects1.sort(Comparator.comparing(Project::getName));

        for (Project project : projects1) {
            System.out.println(String.format("      %s",
                    project.getName()));
        }
    }

    //09
    private void findLatest10Projects() {
        List<Project> projects = entityManager
                .createQuery("FROM Project ORDER BY startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultList();
        projects.sort(Comparator.comparing(Project::getName));

        for (Project project : projects) {
            System.out.println(String.format("Project name: %s%n" +
                            "\tProject Description: %s%n" +
                            "\tProject Start Date:%s%n" +
                            "\tProject End Date: %s",
                    project.getName(),
                    project.getDescription(),
                    project.getStartDate(),
                    project.getEndDate()));
        }
    }

    //10.
    private void increaseSalaries() {
        entityManager.getTransaction().begin();

        List<Employee> employees = entityManager
                .createQuery("FROM Employee e WHERE e.department.id IN (1,2,4,11)", Employee.class)
                .getResultList();

        for (Employee employee : employees) {
            employee.setSalary(employee.getSalary().multiply(BigDecimal.valueOf(1.12)));
            entityManager.persist(employee);
            System.out.println(String.format("%s %s ($%.2f)",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getSalary()));
        }


        entityManager.getTransaction().commit();
    }

    //11.
    private void removeTowns() {
        String town = null;
        try {
            town = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        entityManager.getTransaction().begin();
        AtomicInteger addressesCount = new AtomicInteger();
        entityManager
                .createQuery("FROM Address a WHERE town.name = :town", Address.class)
                .setParameter("town", town)
                .getResultList()
                .forEach(a -> {
                    for (Employee employee : a.getEmployees()) {
                        employee.setAddress(null);
                        entityManager.persist(employee);
                    }
                    entityManager.remove(a);
                    addressesCount.getAndIncrement();
                });

        entityManager.getTransaction().commit();

        Town result = entityManager
                .createQuery("FROM Town WHERE name = :town", Town.class)
                .setParameter("town", town)
                .getSingleResult();

        entityManager.getTransaction().begin();
        entityManager.remove(result);
        entityManager.getTransaction().commit();

        if (addressesCount.get() == 1){
            System.out.println(String.format("%d address in %s deleted",
                    addressesCount.get(),
                    town));
        }else {
            System.out.println(String.format("%d addresses in %s deleted",
                    addressesCount.get(),
                    town));
        }
    }

    //12.
    private void findEmployeesByFirstName() {
        String startWith = null;
        try {
            startWith = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        entityManager
                .createQuery("FROM Employee WHERE firstName LIKE concat(:startWith,'%')", Employee.class)
                .setParameter("startWith", startWith)
                .getResultList()
                .forEach(e -> {
                    System.out.println(String.format("%s %s - %s - ($%.2f)",
                            e.getFirstName(),
                            e.getLastName(),
                            e.getJobTitle(),
                            e.getSalary()));
                });
    }

    //13.
    private void employeesMaximumSalaries() {
        List<Object[]> resultList = entityManager
                .createNativeQuery("SELECT name, max(salary) as 'max_salary' FROM departments\n" +
                        "JOIN employees e on departments.department_id = e.department_id\n" +
                        "GROUP BY e.department_id\n" +
                        "HAVING max_salary NOT BETWEEN 30000 AND 70000")
                .getResultList();

        for (Object[] objects : resultList) {
            System.out.println(String.format("%s - %.2f",
                    objects[0],
                    objects[1]));
        }
    }
}
