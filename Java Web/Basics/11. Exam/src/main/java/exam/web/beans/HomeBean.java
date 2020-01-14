package exam.web.beans;

import exam.domain.models.service.HeroServiceModel;
import exam.domain.models.view.HeroViewModel;
import exam.service.HeroService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class HomeBean extends BaseBean {

    private List<HeroViewModel> models;

    private HeroService heroService;
    private ModelMapper mapper;

    public HomeBean() {
    }

    @Inject
    public HomeBean(HeroService heroService, ModelMapper mapper) {
        this.heroService = heroService;
        this.mapper = mapper;
        this.init();
    }

    @PostConstruct
    private void init() {
        models = heroService.findAllHeroes()
        .stream()
        .map(h -> mapper.map(h, HeroViewModel.class))
        .collect(Collectors.toList());
    }


    public List<HeroViewModel> getModels() {
        return models;
    }

    public void setModels(List<HeroViewModel> models) {
        this.models = models;
    }
}
