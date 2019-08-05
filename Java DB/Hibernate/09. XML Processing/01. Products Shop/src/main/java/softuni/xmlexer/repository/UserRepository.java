package softuni.xmlexer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.xmlexer.domain.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT *\n" +
            "FROM users AS u\n" +
            "         JOIN products p on u.id = p.seller_id\n" +
            "WHERE p.buyer_id IS NOT NULL\n" +
            "GROUP BY u.id\n" +
            "HAVING count(p.id) > 0\n" +
            "ORDER BY u.last_name, u.first_name",nativeQuery = true)
    List<User> getAllWithAtLeastOneSoldProductWithABuyer();

    @Query("FROM User AS u WHERE u.sold.size > 1 ORDER BY u.sold.size DESC, u.lastName")
    List<User> getAllWithAtLeastOneSoldProduct();
}
