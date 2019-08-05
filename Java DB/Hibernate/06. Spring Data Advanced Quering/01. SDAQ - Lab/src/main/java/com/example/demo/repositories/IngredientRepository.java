package com.example.demo.repositories;

import com.example.demo.domain.entities.Ingredient;
import com.example.demo.domain.entities.Shampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findAllByNameStartsWith(String letters);

    @Query("SELECT i from Ingredient as i where i.name in :names")
    List<Ingredient> findAllByNameOrderByPrice(Set<String> names);

    @Query(value = "select s from Shampoo s join s.ingredients i where i in :ingredients")
    List<Shampoo> findByIngredientsIn(@Param(value = "ingredients")
                                              Set<Ingredient> ingredients);

    Ingredient findByName(String name);

    @Transactional
    @Modifying
    @Query("DELETE from Ingredient i where i.name = :name")
    void deleteByName(String name);

    @Transactional
    @Modifying
    @Query("UPDATE Ingredient i set i.price = i.price * :percent")
    void updatePriceOfAllByPercent(BigDecimal percent);
}
