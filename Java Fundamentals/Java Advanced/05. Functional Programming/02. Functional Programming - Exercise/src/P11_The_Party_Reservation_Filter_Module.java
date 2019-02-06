import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11_The_Party_Reservation_Filter_Module {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> people = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());

        Map<String, Predicate<String>> filterModule = new HashMap<>();

        while (true){
            String[] line = reader.readLine().split(";");
            String cmd = line[0];
            if ("Print".equals(cmd)){
                break;
            }
            String chosenOne = line[2];
            String key = line[1].concat(chosenOne);

            if (cmd.startsWith("Add")){
                Predicate<String> add = null;

                if (key.startsWith("Starts")){
                    add = x -> !x.startsWith(chosenOne);
                }else if (key.startsWith("Ends")){
                    add = x -> !x.endsWith(chosenOne);
                }else if (key.startsWith("Length")){
                    int currentLength = Integer.parseInt(chosenOne);
                    add = x -> x.length() != currentLength;
                }else if (key.startsWith("Contains")){
                    add = x -> !x.contains(chosenOne);
                }

                filterModule.putIfAbsent(key, add);
            }else {
                filterModule.remove(key);
            }
        }
        for (var filters : filterModule.entrySet()) {
           people = people.stream().filter(filters.getValue()).collect(Collectors.toList());
        }

        System.out.println(String.join(" ", people));
    }
}
