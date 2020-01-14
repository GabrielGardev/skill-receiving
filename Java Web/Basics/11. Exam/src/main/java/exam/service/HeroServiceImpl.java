package exam.service;

import exam.domain.entities.Hero;
import exam.domain.models.service.HeroServiceModel;
import exam.repository.HeroRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class HeroServiceImpl implements HeroService {

    private final HeroRepository heroRepository;
    private final ModelMapper mapper;

    @Inject
    public HeroServiceImpl(HeroRepository heroRepository, ModelMapper mapper) {
        this.heroRepository = heroRepository;
        this.mapper = mapper;
    }

    @Override
    public void createHero(HeroServiceModel heroServiceModel) {
        Hero hero = mapper.map(heroServiceModel, Hero.class);
        heroRepository.save(hero);
    }

    @Override
    public void deleteHeroById(String id) {
        heroRepository.deleteById(id);
    }

    @Override
    public List<HeroServiceModel> findAllHeroes() {
        return heroRepository.findAll()
                .stream()
                .map(h -> mapper.map(h, HeroServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public HeroServiceModel findById(String id) {
        Hero hero = heroRepository.findById(id);
        return mapper.map(hero, HeroServiceModel.class);
    }

    @Override
    public HeroServiceModel findByName(String name) {
        Hero hero = heroRepository.findByName(name);
        return mapper.map(hero, HeroServiceModel.class);
    }
}
