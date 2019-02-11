package P07_Custom_List;

import java.util.Scanner;

public class Engine implements Runnable {

    private static final String COMMAND_END = "END";
    private Scanner scanner;
    private Commands commands;

    @Override
    public void run() {
        this.commands = new Commands();
        this.scanner =  new Scanner(System.in);

        while (true){
            String line = this.scanner.nextLine();
            if (line.equals(COMMAND_END)){
                break;
            }

            this.commands.setCommand(line);
            this.commands.execute();
        }
    }
}
