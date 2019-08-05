package app.ccb.repositories;

import app.ccb.domain.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    Optional<Client> getByFullName(String fullName);

    @Query(nativeQuery = true, value = "SELECT *\n" +
            "FROM clients\n" +
            "         JOIN bank_accounts ba on clients.id = ba.client_id\n" +
            "         JOIN cards c2 on ba.id = c2.bank_account_id\n" +
            "GROUP BY client_id\n" +
            "ORDER BY count(c2.id) DESC\n" +
            "LIMIT 1;")
    Client exportFamilyGuy();
}
