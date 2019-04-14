package system;

import interfaces.CommandHandler;
import interfaces.Executor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecutorImpl implements Executor {
    private static final String END_COMMAND = "End";

    private CommandHandler commandHandler;
    private BufferedReader reader;

    public ExecutorImpl() {
        this.commandHandler = new CommandHandlerImpl(new Controller());
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void execute() throws IOException {

        while (true){
            String[] data = this.reader.readLine().split("\\\\");
            String result;

            try {
                result = this.commandHandler.handle(data);
            }catch (Exception e){
                System.out.println(e.getMessage());
                continue;
            }

            if (result.equals(ExecutorImpl.END_COMMAND)){
                break;
            }

            System.out.println(result);

        }
    }
}
