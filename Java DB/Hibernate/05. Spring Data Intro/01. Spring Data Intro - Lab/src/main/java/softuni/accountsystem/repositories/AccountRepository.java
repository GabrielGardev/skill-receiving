package softuni.accountsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.accountsystem.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsAccountById(Long id);

}
