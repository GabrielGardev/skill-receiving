import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class P07_Fix_Emails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        var emails = new LinkedHashMap<String, String>();

        while (!command.equals("stop"))
        {
            String name = command;
            String email = reader.readLine();


            if (!(email.toLowerCase().endsWith("us") || email.toLowerCase().endsWith("uk") || email.toLowerCase().endsWith("com")))
            {
                emails.put(name, email);
            }

            command = reader.readLine();
        }
        for (var item : emails.entrySet())
        {
            System.out.println(String.format("%s -> %s", item.getKey(), item.getValue()));
        }
    }
}
