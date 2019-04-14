package repositories;

import exceptions.DuplicateModelException;
import exceptions.NonExistantModelException;
import models.engines.Engine;

import java.util.HashMap;
import java.util.Map;

class EngineRepository {
    private Map<String, Engine> repository;

    EngineRepository() {
        this.repository = new HashMap<>();
    }

    Engine getEngineByModel(String model) throws NonExistantModelException {
        if (!this.repository.containsKey(model)){
           throw new NonExistantModelException();
        }
        return this.repository.get(model);
    }

    void add(Engine engine) throws DuplicateModelException {
        if (this.repository.containsKey(engine.getModel())){
            throw new DuplicateModelException();
        }
        this.repository.put(engine.getModel(), engine);
    }
}
