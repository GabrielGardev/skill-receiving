package pr0304Barracks.core;

import pr0304Barracks.annotations.Inject;
import pr0304Barracks.contracts.CommandInterpreter;
import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String COMMAND_PATH = "pr0304Barracks.core.commands.";

    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Executable interpretCommand(String[] data) {
        String commandName = Character.toUpperCase(data[0].charAt(0))
                + data[0].substring(1);

        Executable executable = null;
        try {
            Class<? extends Executable> aClass =
                    (Class<? extends Executable>)
                            Class.forName(CommandInterpreterImpl.COMMAND_PATH + commandName);

            Constructor<? extends Executable> declaredConstructor =
                    aClass.getDeclaredConstructor(String[].class);

            executable = declaredConstructor.newInstance(new Object[]{data});

            Field[] declaredFields = executable.getClass().getDeclaredFields();
            Field[] thisFields = this.getClass().getDeclaredFields();

            for (Field declaredField : declaredFields) {
                if (declaredField.isAnnotationPresent(Inject.class)){
                    for (Field thisField : thisFields) {
                        if (declaredField.getType().equals(thisField.getType())){
                            declaredField.setAccessible(true);
                            declaredField.set(executable, thisField.get(this));
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return executable;
    }
}
