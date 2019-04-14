package repositories;

import exceptions.DuplicateModelException;
import exceptions.NonExistantModelException;
import models.boats.Boat;

import java.util.HashMap;
import java.util.Map;

class BoatRepository {
    private Map<String, Boat> repository;

    BoatRepository() {
        this.repository = new HashMap<>();
    }

    Boat getBoatByModel(String model) throws NonExistantModelException {
        if (!this.repository.containsKey(model)){
            throw new NonExistantModelException();
        }
        return this.repository.get(model);
    }

    void add(Boat boat) throws DuplicateModelException {
        if (this.repository.containsKey(boat.getModel())){
            throw new DuplicateModelException();
        }
        this.repository.put(boat.getModel(), boat);
    }
}
