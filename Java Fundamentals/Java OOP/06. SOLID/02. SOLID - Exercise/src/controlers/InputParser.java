package controlers;

import java.io.BufferedReader;
import java.io.IOException;

public class InputParser {

    public String readLoggerInfo(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());

        StringBuilder sb = new StringBuilder();
        while (n-- > 0){
            sb.append(reader.readLine()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
