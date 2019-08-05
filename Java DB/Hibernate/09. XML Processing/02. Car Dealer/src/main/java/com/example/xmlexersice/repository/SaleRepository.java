package com.example.xmlexersice.repository;

import com.example.xmlexersice.domain.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {

    @Query("FROM Sale s WHERE s.discount > 0")
    List<Sale> getAllWithDiscount();
}
