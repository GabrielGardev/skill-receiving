package P04_Word;

public class Initialization {
    public static CommandInterface buildCommandInterface(StringBuilder text) {
        CommandInterface command = new AdvancedCommands(text);
        command.init();
        return command;
    }
}
