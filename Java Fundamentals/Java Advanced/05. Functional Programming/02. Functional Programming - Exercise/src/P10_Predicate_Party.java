import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class P10_Predicate_Party {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BiFunction<List<String>, String, List<String>> doubleOrRemovePersonStartsWith = (l, x) -> {
            List<String> newPeople = new ArrayList<>();
            for (String s : l) {
                if (s.startsWith(x)) {
                    newPeople.add(s);
                }
            }
            return newPeople;
        };

        BiFunction<List<String>, String, List<String>> doubleOrRemovePersonEndsWith = (l, x) -> {
            List<String> newPeople = new ArrayList<>();
            for (String s : l) {
                if (s.endsWith(x)) {
                    newPeople.add(s);
                }
            }
            return newPeople;
        };

        BiFunction<List<String>, Integer, List<String>> doubleOrRemovePersonByLength = (l, x) -> {
            List<String> newPeople = new ArrayList<>();
            for (String s : l) {
                if (s.length() == x) {
                    newPeople.add(s);
                }
            }
            return newPeople;
        };


        List<String> people = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());

        while (true) {
            String[] line = reader.readLine().split("\\s+");
            String doubleOrRemove = line[0];
            if ("Party!".equals(doubleOrRemove)) {
                break;
            }
            String cmd = line[1].toLowerCase();
            String chosenOne = line[2];

            if (doubleOrRemove.toLowerCase().equals("double")) {

                if (cmd.equals("startswith")) {

                    people.addAll(doubleOrRemovePersonStartsWith.apply(people, chosenOne));
                } else if (cmd.equals("endswith")) {

                    people.addAll(doubleOrRemovePersonEndsWith.apply(people, chosenOne));
                } else if (cmd.equals("length")) {

                    int givenLength = Integer.parseInt(chosenOne);
                    people.addAll(doubleOrRemovePersonByLength.apply(people, givenLength));
                }
            } else if (doubleOrRemove.toLowerCase().equals("remove")) {
                if (cmd.equals("startswith")) {
                    people.removeAll(doubleOrRemovePersonStartsWith.apply(people, chosenOne));
                } else if (cmd.equals("endswith")) {
                    people.removeAll(doubleOrRemovePersonEndsWith.apply(people, chosenOne));
                } else if (cmd.equals("length")) {
                    int givenLength = Integer.parseInt(chosenOne);
                    people.removeAll(doubleOrRemovePersonByLength.apply(people, givenLength));
                }
            }
        }
        if (people.size() > 0) {
            people.sort(String::compareTo);
            System.out.println(String.join(", ", people) + " are going to the party!");
        }else {
            System.out.println("Nobody is going to the party!");
        }

    }
}
