package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.exam.domain.entities.Player;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    @Query("FROM Player p WHERE p.team.name = ?1 ORDER BY p.id")
    List<Player> findPlayersInATeam(String name);

    List<Player> findAllBySalaryGreaterThanOrderBySalaryDesc(BigDecimal salary);
}
