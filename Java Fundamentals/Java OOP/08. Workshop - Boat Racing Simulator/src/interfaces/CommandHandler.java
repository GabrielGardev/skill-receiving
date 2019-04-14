package interfaces;

import exceptions.*;

public interface CommandHandler {
    String handle(String[] data) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException, ArgumentException;
}
