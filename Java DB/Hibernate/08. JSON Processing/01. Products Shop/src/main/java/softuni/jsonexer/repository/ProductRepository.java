package softuni.jsonexer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.jsonexer.domain.entity.Product;
import softuni.jsonexer.domain.entity.User;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByPriceBetweenAndBuyerIdIsNullOrderByPrice(BigDecimal more, BigDecimal less);

}
