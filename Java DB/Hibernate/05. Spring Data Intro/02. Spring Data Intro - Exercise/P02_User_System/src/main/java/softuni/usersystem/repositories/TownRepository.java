package softuni.usersystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.usersystem.entities.Town;

@Repository
public interface TownRepository extends JpaRepository<Town, Integer> {
}
