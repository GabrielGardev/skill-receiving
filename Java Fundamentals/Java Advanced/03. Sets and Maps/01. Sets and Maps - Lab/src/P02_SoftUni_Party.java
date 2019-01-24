import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

public class P02_SoftUni_Party {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<String> guestList = new TreeSet<>();

        while (true){
            String line = reader.readLine();
            if (line.equals("PARTY")){
                break;
            }
            guestList.add(line);
        }

        while (true){
            String line = reader.readLine();
            if (line.equals("END")){
                break;
            }
            guestList.remove(line);
        }
        System.out.println(guestList.size());
        guestList.stream()
                .forEach(System.out::println);
    }
}
