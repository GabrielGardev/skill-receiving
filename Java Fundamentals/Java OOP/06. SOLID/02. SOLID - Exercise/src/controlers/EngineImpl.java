package controlers;

import enums.ReportLevel;
import interfeaces.Engine;
import interfeaces.Logger;

import java.io.BufferedReader;
import java.io.IOException;

public class EngineImpl implements Engine {
    private Logger logger;

    public EngineImpl(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void run(String endString, BufferedReader reader) throws IOException {

        while (true){
            String input = reader.readLine();
            if (endString.equals(input)){
                break;
            }

            String[] tokens = input.split("\\|");

            String time = tokens[1];
            String message = tokens[2];

            this.logger.log(time, message, ReportLevel.valueOf(tokens[0]));
        }
    }

    @Override
    public String toString() {
        return this.logger.toString();
    }
}
