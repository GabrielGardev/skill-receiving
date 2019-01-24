package softuni.ebank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.ebank.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByAuthority(String authority);
}
