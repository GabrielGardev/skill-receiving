package exam.web.beans;

import exam.domain.models.view.HeroViewModel;
import exam.service.HeroService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class HeroDetailsBean extends BaseBean {

    private HeroViewModel heroViewModel;

    private HeroService heroService;
    private ModelMapper mapper;

    public HeroDetailsBean() {
    }

    @Inject
    public HeroDetailsBean(HeroService heroService, ModelMapper mapper) {
        this.heroService = heroService;
        this.mapper = mapper;
        this.init();
    }

    @PostConstruct
    private void init() {
        String id = getRequestParameterMap().get("id");
        this.heroViewModel = mapper.map(heroService.findById(id), HeroViewModel.class);
    }

    public HeroViewModel getHeroViewModel() {
        return heroViewModel;
    }

    public void setHeroViewModel(HeroViewModel heroViewModel) {
        this.heroViewModel = heroViewModel;
    }
}
