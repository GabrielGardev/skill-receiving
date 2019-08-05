package softuni.cardealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.cardealer.domains.entities.Car;

import java.util.Set;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    Set<Car> findAllByMakeOrderByModelAscTravelledDistanceDesc(String make);
}
