package exam.web.beans;

import exam.domain.models.binding.HeroCreateBindingModel;
import exam.domain.models.service.HeroServiceModel;
import exam.service.HeroService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class HeroCreateBean extends BaseBean {

    private HeroCreateBindingModel heroCreateBindingModel;

    private HeroService heroService;
    private ModelMapper mapper;

    public HeroCreateBean() {
    }

    @Inject
    public HeroCreateBean(HeroService heroService, ModelMapper mapper) {
        this.heroService = heroService;
        this.mapper = mapper;
        this.heroCreateBindingModel = new HeroCreateBindingModel();
    }


    public HeroCreateBindingModel getHeroCreateBindingModel() {
        return heroCreateBindingModel;
    }

    public void setHeroCreateBindingModel(HeroCreateBindingModel heroCreateBindingModel) {
        this.heroCreateBindingModel = heroCreateBindingModel;
    }

    public void create(){
        HeroServiceModel serviceModel = mapper.map(heroCreateBindingModel, HeroServiceModel.class);
        heroService.createHero(serviceModel);
        redirect("/home");
    }
}
