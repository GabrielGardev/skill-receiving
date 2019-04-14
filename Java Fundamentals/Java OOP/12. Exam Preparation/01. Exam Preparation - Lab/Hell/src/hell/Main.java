package hell;

import hell.input_output.InputReaderImpl;
import hell.input_output.OutputWriterImpl;
import hell.interfaces.InputReader;
import hell.interfaces.Manager;
import hell.interfaces.OutputWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Manager manager = new ManagerImpl();
        InputReader inputReader = new InputReaderImpl();
        OutputWriter outputWriter = new OutputWriterImpl();

        while (true){
            List<String> line = Arrays.stream(inputReader.readLine().split("\\s+")).collect(Collectors.toList());
            String command = line.get(0);
            if (command.equals("Quit")){
                outputWriter.writeLine(manager.quit());
                break;
            }
            String result = "";

            switch (command){
                case "Hero":
                    result = manager.addHero(line);
                    break;
                case "Item":
                    result = manager.addItem(line);
                    break;
                case "Recipe":
                    result = manager.addRecipe(line);
                    break;
                case "Inspect":
                    result = manager.inspect(line);
                    break;
            }

            outputWriter.writeLine(result);
        }

    }
}