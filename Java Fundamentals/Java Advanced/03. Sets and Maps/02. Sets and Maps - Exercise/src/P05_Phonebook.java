import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P05_Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String , String> phonebook = new HashMap<>();

        while (true){
            String []line = reader.readLine().split("-");
            if ("search".equals(line[0])){
                break;
            }
            String name = line[0];
            String number = line[1];

            phonebook.put(name, number);

        }

        while (true){
            String name = reader.readLine();
            if ("stop".equals(name)){
                break;
            }
            if (phonebook.containsKey(name)){
                System.out.println(String.format("%s -> %s", name, phonebook.get(name)));
            }else {
                System.out.println(String.format("Contact %s does not exist.", name));
            }
        }
    }
}
