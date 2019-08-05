package com.example.demo.repositories;

import com.example.demo.domain.entities.Shampoo;
import com.example.demo.domain.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findAllBySizeOrderById(Size size);
    List<Shampoo> findAllByIdOrSizeOrderByPrice(long id, Size size);
    List<Shampoo> findAllByPriceAfterOrderByPriceDesc(BigDecimal price);

    @Query(value = "SELECT count(s.id) as 'count'\n" +
            "from shampoos as s\n" +
            "WHERE s.price < :price\n" +
            "GROUP BY 'count'", nativeQuery = true)
    List<Object[]> findAllGroupedByPrice(BigDecimal price);

    @Query("SELECT s FROM Shampoo as s WHERE s.ingredients.size < :num")
    List<Shampoo> findAllByIngredientsLessThan(@Param(value = "num") int num);

    List<Object[]> findPriceOfIngredients(@Param(value = "name") String name);
}
