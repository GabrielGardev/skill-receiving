package exam.service;

import exam.domain.models.service.HeroServiceModel;

import java.util.List;

public interface HeroService {

    void createHero(HeroServiceModel heroServiceModel);

    void deleteHeroById(String id);

    List<HeroServiceModel> findAllHeroes();

    HeroServiceModel findById(String id);

    HeroServiceModel findByName(String name);
}
