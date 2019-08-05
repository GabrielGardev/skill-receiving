package alararestaurant.repository;

import alararestaurant.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByName(String name);

    @Query(value = "select c from Category as c " +
            "inner join c.items as i " +
            "group by c.name " +
            "order by size(c.items) desc, sum(i.price) desc ")
    List<Category> findCategoriesByCountOfItems();
}
