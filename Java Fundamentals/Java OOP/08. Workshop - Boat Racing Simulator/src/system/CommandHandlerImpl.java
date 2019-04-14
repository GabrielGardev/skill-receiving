package system;

import exceptions.*;
import interfaces.CommandHandler;

public class CommandHandlerImpl implements CommandHandler {
    private Controller controller;

    public CommandHandlerImpl(Controller controller) {
        this.controller = controller;
    }

    @Override
    public String handle(String[] data) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException, ArgumentException {
        String command = data[0];
        String result = "";

        switch (command){
            case "CreateBoatEngine":
                result = this.controller.createEngine(data);
                break;
            case "CreateRowBoat":
                result = this.controller.createRowBoat(data);
                break;
            case "CreateSailBoat":
                result = this.controller.createSailBoat(data);
                break;
            case "CreatePowerBoat":
                result = this.controller.createPowerBoat(data);
                break;
            case "CreateYacht":
                result = this.controller.createYacht(data);
                break;
            case "OpenRace":
                result = this.controller.openRace(data);
                break;
            case "SignUpBoat":
                result = this.controller.singUpBoat(data);
                break;
            case "StartRace":
                result = this.controller.startRace();
                break;
            case "GetStatistic":
                result = this.controller.getStatistic();
                break;
            case "End":
                result = "End";
                break;
        }
        return result;
    }
}
