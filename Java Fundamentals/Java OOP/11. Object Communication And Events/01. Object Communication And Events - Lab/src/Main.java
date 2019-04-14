import commands.*;
import resources.Attacker;
import resources.Dragon;
import resources.Target;
import resources.Warrior;

public class Main {
    public static void main(String[] args) {
        Attacker warrior = new Warrior("Warrior", 10);
        Target dragon = new Dragon("Dragon", 5, 25);

        Executor executor = new CommandExecutor();
        Command target = new TargetCommand(warrior, dragon);
        Command attacker = new AttackCommand(warrior);

        executor.executeCommand(target);
        executor.executeCommand(attacker);

    }
}
