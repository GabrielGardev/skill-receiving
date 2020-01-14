package metube.service;

import metube.domain.entities.Tube;
import metube.domain.entities.User;
import metube.domain.models.service.TubeServiceModel;
import metube.repository.TubeRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class TubeServiceImpl implements TubeService{

    private final TubeRepository tubeRepository;
    private final ModelMapper mapper;

    @Inject
    public TubeServiceImpl(TubeRepository tubeRepository, ModelMapper mapper) {
        this.tubeRepository = tubeRepository;
        this.mapper = mapper;
    }

    @Override
    public boolean uploadTube(TubeServiceModel tubeServiceModel) {
        try {
            Tube tube = mapper.map(tubeServiceModel, Tube.class);
            tube.setUploader(mapper.map(tubeServiceModel.getUploader(), User.class));
            tubeRepository.save(tube);
        }catch (Exception e){
            return false;
        }

        return true;
    }

    @Override
    public List<TubeServiceModel> findAllTubes() {
        List<Tube> tubes = tubeRepository.findAll();
        List<TubeServiceModel> resultList = new ArrayList<>();

        for (Tube tube : tubes) {
            resultList.add(mapper.map(tube, TubeServiceModel.class));
        }
        return resultList;
    }

    @Override
    public TubeServiceModel findTubeById(String id) {
        Tube tube = this.tubeRepository.findById(id);

        if (tube == null) {
            throw new IllegalArgumentException();
        }

        return this.mapper.map(tube, TubeServiceModel.class);
    }

    @Override
    public void updateTube(TubeServiceModel tubeServiceModel) {
        Tube tube = mapper.map(tubeServiceModel, Tube.class);
        this.tubeRepository.update(tube);
    }
}
