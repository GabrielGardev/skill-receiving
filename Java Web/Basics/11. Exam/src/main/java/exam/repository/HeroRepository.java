package exam.repository;

import exam.domain.entities.Hero;

public interface HeroRepository extends GenericRepository<Hero, String> {
    Hero findByName(String name);

    void deleteById(String id);
}
