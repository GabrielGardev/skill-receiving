package metube.service;

import metube.domain.entities.Tube;
import metube.domain.models.service.TubeServiceModel;
import metube.repository.TubeRepository;
import metube.util.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class TubeServiceImpl implements TubeService {

    private final TubeRepository tubeRepository;
    private final ModelMapper modelMapper;

    @Inject
    public TubeServiceImpl(TubeRepository tubeRepository, ModelMapper modelMapper) {
        this.tubeRepository = tubeRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void saveTube(TubeServiceModel tubeServiceModel) {
        Tube tube = modelMapper.map(tubeServiceModel, Tube.class);
        tubeRepository.save(tube);
    }

    @Override
    public List<TubeServiceModel> findAllTubes() {
        return tubeRepository.findAll()
                .stream()
                .map(t -> modelMapper.map(t, TubeServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public TubeServiceModel findTubeByName(String name) {
        Tube tube = tubeRepository.findByName(name).orElse(null);

        return modelMapper.map(tube, TubeServiceModel.class);
    }

    @Override
    public TubeServiceModel findTubeById(String id) {
        Tube tube = tubeRepository.findById(id).orElse(null);

        return modelMapper.map(tube, TubeServiceModel.class);
    }
}
