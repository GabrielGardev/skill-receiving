import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class P01_Unique_Usernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        var names = new LinkedHashSet<String>();

        for (int i = 0; i < n; i++) {
            String name = reader.readLine();

            names.add(name);
        }
        for (String name : names) {
            System.out.println(name);
        }
    }
}
