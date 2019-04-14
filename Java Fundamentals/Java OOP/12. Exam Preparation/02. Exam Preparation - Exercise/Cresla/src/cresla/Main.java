package cresla;

import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Manager manager = new ManagerImpl();
        InputReader inputReader = new InputReaderImpl();
        OutputWriter outputWriter = new OutputWriterImpl();

        while (true) {
            List<String> line = Arrays.stream(inputReader.readLine().split("\\s+"))
                    .collect(Collectors.toList());

            String result = "";

            String command = line.get(0);
            if ("Exit".equals(command)) {
                result = manager.exitCommand(new ArrayList<>());

                if (result != null) {
                    outputWriter.writeLine(result);
                }

                break;
            }


            line = line.stream().skip(1).collect(Collectors.toList());

            switch (command) {
                case "Reactor":
                    result = manager.reactorCommand(line);
                    break;
                case "Module":
                    result = manager.moduleCommand(line);
                    break;
                case "Report":
                    result = manager.reportCommand(line);
                    break;
            }
            if (result != null) {
                outputWriter.writeLine(result);
            }
        }
    }
}
