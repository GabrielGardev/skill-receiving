package metube.service;

import metube.domain.models.service.TubeServiceModel;

import java.util.List;

public interface TubeService {
    void saveTube(TubeServiceModel tubeServiceModel);

    List<TubeServiceModel> findAllTubes();

    TubeServiceModel findTubeByName(String name);

    TubeServiceModel findTubeById(String id);
}
