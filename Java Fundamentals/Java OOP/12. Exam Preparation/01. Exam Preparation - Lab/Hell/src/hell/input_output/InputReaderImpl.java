package hell.input_output;

import hell.interfaces.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReaderImpl implements InputReader {
    private BufferedReader reader;

    public InputReaderImpl() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() {
        String result = "";
        try {
            result = reader.readLine();
        } catch (IOException ignored) {

        }

        return result;
    }
}
