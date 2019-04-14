import interfaces.Executor;
import system.ExecutorImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Executor executor = new ExecutorImpl();
        executor.execute();
    }
}
