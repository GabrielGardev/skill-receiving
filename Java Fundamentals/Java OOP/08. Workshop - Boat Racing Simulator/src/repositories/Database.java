package repositories;

import exceptions.DuplicateModelException;
import exceptions.NonExistantModelException;
import models.boats.Boat;
import models.engines.Engine;

public class Database {
    private EngineRepository engineRepository;
    private BoatRepository boatRepository;

    public Database() {
        this.engineRepository = new EngineRepository();
        this.boatRepository = new BoatRepository();
    }

    public Boat getBoatByModel(String model) throws NonExistantModelException {
        return this.boatRepository.getBoatByModel(model);
    }

    public Engine getEngineByModel(String model) throws NonExistantModelException {
       return this.engineRepository.getEngineByModel(model);
    }

    public void addEngine(Engine engine) throws DuplicateModelException {
        this.engineRepository.add(engine);
    }

    public void addBoat(Boat boat) throws DuplicateModelException {
        this.boatRepository.add(boat);
    }
}
