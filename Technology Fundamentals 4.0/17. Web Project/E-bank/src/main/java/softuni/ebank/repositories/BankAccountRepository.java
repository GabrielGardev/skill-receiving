package softuni.ebank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.ebank.entities.BankAccount;

import java.util.List;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount,Long> {
    List<BankAccount> findAllByOwnerUsername(String username);
}
