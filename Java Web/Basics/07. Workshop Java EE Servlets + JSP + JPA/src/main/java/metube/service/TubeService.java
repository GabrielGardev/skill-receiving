package metube.service;

import metube.domain.models.service.TubeServiceModel;

import java.util.List;

public interface TubeService {

    boolean uploadTube(TubeServiceModel tubeServiceModel);

    List<TubeServiceModel> findAllTubes();

    TubeServiceModel findTubeById(String id);

    void updateTube(TubeServiceModel tubeServiceModel);
}
