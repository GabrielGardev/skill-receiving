package system;

import exceptions.*;
import models.Race;
import models.boats.*;
import models.engines.Engine;
import models.engines.JetEngine;
import models.engines.SterndriveEngine;
import repositories.Database;

import java.util.*;

public class Controller {
    private static final String JET_ENGINE = "Jet";
    private static final String STERNDRIVE_ENGINE = "Sterndrive";


    private Database database;
    private Race race;

    public Controller() {
        this.database = new Database();
        this.race = null;
    }

    public String createEngine(String[] data) throws DuplicateModelException, ArgumentException {
        String model = data[1];
        int horsepower = Integer.parseInt(data[2]);
        int displacement = Integer.parseInt(data[3]);
        String type = data[4];

        Engine engine;

        if (type.equals(Controller.JET_ENGINE)) {
            engine = new JetEngine(model, horsepower, displacement);
        } else if (type.equals(Controller.STERNDRIVE_ENGINE)) {
            engine = new SterndriveEngine(model, horsepower, displacement);
        } else {
            throw new ArgumentException();
        }

        this.database.addEngine(engine);
        return engine.toString();
    }

    public String createRowBoat(String[] data) throws DuplicateModelException, ArgumentException {
        String model = data[1];
        int weight = Integer.parseInt(data[2]);
        int oars = Integer.parseInt(data[3]);

        Boat boat = new RowBoat(model, weight, oars);
        this.database.addBoat(boat);

        return "Row boat " + boat.toString();
    }

    public String createSailBoat(String[] data) throws DuplicateModelException, ArgumentException {
        String model = data[1];
        int weight = Integer.parseInt(data[2]);
        int sailEfficiency = Integer.parseInt(data[3]);

        Boat boat = new SailBoat(model, weight, sailEfficiency);
        this.database.addBoat(boat);

        return "Sail boat " + boat.toString();
    }

    public String createPowerBoat(String[] data) throws NonExistantModelException, DuplicateModelException, ArgumentException {
        String model = data[1];
        int weight = Integer.parseInt(data[2]);
        Engine firstEngine = this.database.getEngineByModel(data[3]);
        Engine secondEngine = this.database.getEngineByModel(data[4]);

        Boat boat = new PowerBoat(model, weight, firstEngine, secondEngine);
        this.database.addBoat(boat);

        return "Power boat " + boat.toString();
    }

    public String createYacht(String[] data) throws NonExistantModelException, DuplicateModelException, ArgumentException {
        String model = data[1];
        int weight = Integer.parseInt(data[2]);
        Engine engine = this.database.getEngineByModel(data[3]);
        int cargoWeight = Integer.parseInt(data[4]);

        Boat boat = new Yacht(model, weight, engine, cargoWeight);
        this.database.addBoat(boat);

        return "Yacht " + boat.toString();
    }

    public String openRace(String[] data) throws RaceAlreadyExistsException, ArgumentException {
        if (this.race != null) {
            throw new RaceAlreadyExistsException("The current race has already been set.");
        }

        int distance = Integer.parseInt(data[1]);
        int windSpeed = Integer.parseInt(data[2]);
        int oceanCurrentSpeed = Integer.parseInt(data[3]);
        boolean allowMotors = Boolean.parseBoolean(data[4]);

        this.race = new Race(distance, windSpeed, oceanCurrentSpeed, allowMotors);

        return this.race.toString();
    }

    public String singUpBoat(String[] data) throws NoSetRaceException, NonExistantModelException, DuplicateModelException, ArgumentException {
        String model = data[1];

        if (this.race == null) {
            throw new NoSetRaceException("There is currently no race set.");
        }
        Boat boat = this.database.getBoatByModel(model);

        if (!this.race.isAllowMotorboats() && boat.HasEngine()) {
            throw new ArgumentException("The specified boat does not meet the race constraints.");
        }

        this.race.addParticipant(boat);

        return String.format("Boat with model %s has signed up for the current Race.", boat.getModel());
    }

    public String startRace() throws NoSetRaceException, InsufficientContestantsException {
        if (this.race == null) {
            throw new NoSetRaceException("There is currently no race set.");
        }

        if (this.race.getParticipants().size() < 3) {
            throw new InsufficientContestantsException("Not enough contestants for the race.");
        }
        StringBuilder sb = new StringBuilder();

        Boat[] boats = this.race.getParticipants().values()
                .stream()
                .sorted((a, b) -> {
                    double boatATime = this.race.getDistance() / a.getSpeed(this.race.getConditions());
                    double boatBTime = this.race.getDistance() / b.getSpeed(this.race.getConditions());
                    if (boatATime <= 0 && boatBTime <= 0) {
                        return 0;
                    }

                    return Double.compare(boatATime, boatBTime);
                })
                .toArray(Boat[]::new);

        this.segregateElements(boats);

        sb.append("First place: ");
        sb.append(appendResult(boats[0]));
        sb.append(System.lineSeparator());
        sb.append("Second place: ");
        sb.append(appendResult(boats[1]));
        sb.append(System.lineSeparator());
        sb.append("Third place: ");
        sb.append(appendResult(boats[2]));

        this.race = null;
        return sb.toString();
    }

    private void segregateElements(Boat[] boats) {
        Boat[] temp = new Boat[boats.length];
        int j = 0;
        for (Boat boat : boats) {
            if (boat.getSpeed(this.race.getConditions()) > 0) {
                temp[j++] = boat;
            }
        }
        if (j == boats.length || j == 0) return;
        for (Boat boat : boats) {
            if (boat.getSpeed(this.race.getConditions()) <= 0) {
                temp[j++] = boat;
            }
        }
        System.arraycopy(temp, 0, boats, 0, boats.length);
    }

    private String appendResult(Boat boat) {
        double raceTime = this.race.getDistance() / boat.getSpeed(this.race.getConditions());

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s Model: %s Time: ",
                boat.getClass().getSimpleName(),
                boat.getModel()));

        if (boat.getSpeed(this.race.getConditions()) <= 0){
            sb.append("Did not finish!");
        }else {
            sb.append(String.format("%.2f sec", raceTime));
        }
        return sb.toString();
    }

    public String getStatistic() throws NoSetRaceException {
        if (this.race == null){
            throw new NoSetRaceException("There is currently no race set.");
        }

        double total = this.race.getParticipants().size();
        Map<String, Integer> participants = new TreeMap<>() {{
            put("PowerBoat", 0);
            put("RowBoat", 0);
            put("SailBoat", 0);
            put("Yacht", 0);
        }};


        for (Boat value : this.race.getParticipants().values()) {
            for (String type : participants.keySet()) {
                if (value.getClass().getSimpleName().equals(type)) {
                    participants.put(type, participants.get(type) + 1);
                }
            }
        }

        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : participants.entrySet()) {
            if (entry.getValue() > 0) {
                result.add(String.format("%s -> %.2f%s", entry.getKey(),
                        entry.getValue() / total * 100.0, "%"));
            }
        }

        return String.join(System.lineSeparator(), result);
    }
}
