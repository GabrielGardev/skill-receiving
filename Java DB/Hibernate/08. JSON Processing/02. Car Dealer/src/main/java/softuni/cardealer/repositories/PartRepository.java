package softuni.cardealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.cardealer.domains.entities.Part;

import java.util.Optional;

@Repository
public interface PartRepository extends JpaRepository<Part, Integer> {
}
