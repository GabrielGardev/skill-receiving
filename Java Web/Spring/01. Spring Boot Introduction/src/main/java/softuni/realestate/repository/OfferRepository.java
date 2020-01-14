package softuni.realestate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.realestate.domain.entities.Offer;

public interface OfferRepository extends JpaRepository<Offer, String> {
}
