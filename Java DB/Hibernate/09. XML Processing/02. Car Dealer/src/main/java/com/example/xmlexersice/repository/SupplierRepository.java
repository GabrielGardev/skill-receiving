package com.example.xmlexersice.repository;

import com.example.xmlexersice.domain.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    List<Supplier> getAllByImporterFalse();
}
