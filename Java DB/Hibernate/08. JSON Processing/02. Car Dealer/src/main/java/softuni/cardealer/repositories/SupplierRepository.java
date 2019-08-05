package softuni.cardealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.cardealer.domains.entities.Supplier;

import java.util.List;
import java.util.Set;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    @Query("FROM Supplier s WHERE s.isImporter = false")
    List<Supplier> getAllByImporterIsFalse();
}
