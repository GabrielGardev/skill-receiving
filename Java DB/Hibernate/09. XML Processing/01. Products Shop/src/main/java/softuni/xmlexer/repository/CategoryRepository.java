package softuni.xmlexer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.xmlexer.domain.entity.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("FROM Category AS c ORDER BY c.products.size DESC")
    List<Category> getAllOrderedByCountOfProductsDesc();
}
