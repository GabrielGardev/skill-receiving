package softuni.ebank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.ebank.entities.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
