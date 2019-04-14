package models;

import exceptions.ArgumentException;
import exceptions.DuplicateModelException;
import models.boats.Boat;

import java.util.LinkedHashMap;
import java.util.Map;

public class Race {
    private int distance;
    private Conditions conditions;
    private Map<String, Boat> participants;
    private boolean allowMotorboats;

    public Race(int distance, int windSpeed, int oceanCurrentSpeed, boolean allowMotorboats) throws ArgumentException {
        this.setDistance(distance);
        this.conditions = new Conditions(windSpeed, oceanCurrentSpeed);
        this.participants = new LinkedHashMap<>();
        this.allowMotorboats = allowMotorboats;
    }

    private void setDistance(int distance) throws ArgumentException {
        if (distance <= 0){
            throw new ArgumentException("Distance must be a positive integer.");
        }
        this.distance = distance;
    }

    public void addParticipant(Boat boat) throws DuplicateModelException {
        if (this.participants.containsKey(boat.getModel())){
            throw new DuplicateModelException();
        }
        this.participants.put(boat.getModel(), boat);
    }

    public Map<String, Boat> getParticipants() {
        return participants;
    }

    @Override
    public String toString() {
        return String.format("A new race with distance %d meters," +
                " wind speed %d m/s" +
                " and ocean current speed %d m/s has been set.",
                this.distance,
                this.conditions.getWindSpeed(),
                this.conditions.getOceanCurrentSpeed());
    }

    public boolean isAllowMotorboats() {
        return allowMotorboats;
    }

    public int getDistance() {
        return distance;
    }

    public Conditions getConditions() {
        return conditions;
    }
}
