package com.example.xmlexersice.repository;

import com.example.xmlexersice.domain.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query("FROM Car AS c WHERE c.make =:make ORDER BY c.model ASC, c.travelledDistance DESC")
    List<Car> getAllByMakeOrderByModelThenByTravelledDistanceDesc(@Param("make") String make);
}
