package interfeaces;

import java.io.BufferedReader;
import java.io.IOException;

public interface Engine {
    void run(String endString, BufferedReader reader) throws IOException;
}
