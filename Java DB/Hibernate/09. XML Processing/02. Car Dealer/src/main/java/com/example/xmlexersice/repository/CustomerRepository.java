package com.example.xmlexersice.repository;

import com.example.xmlexersice.domain.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "FROM Customer as c ORDER BY c.birthDate, c.youngDriver")
    List<Customer> getAllOrderedByBirthDateThenByIsYoungDriver();

    @Query("FROM Customer c WHERE c.sales.size > 0")
    List<Customer> getAllWithAtLeastOneSale();
}
