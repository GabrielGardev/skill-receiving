import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P05_Filter_By_Age {
    public static void main(String[] args) throws IOException {
        BiPredicate<Map.Entry<String, Integer>, Integer> youngerThen =
                (person, ageLimit) -> person.getValue() < ageLimit;

        BiPredicate<Map.Entry<String, Integer>, Integer> olderThen =
                (person, ageLimit) -> person.getValue() >= ageLimit;

        Consumer<Map.Entry<String, Integer>> printName = person -> System.out.println(person.getKey());
        Consumer<Map.Entry<String, Integer>> printAge = person -> System.out.println(person.getValue());
        Consumer<Map.Entry<String, Integer>> printNameAndAge = person ->
                System.out.printf("%s - %d%n", person.getKey(), person.getValue());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Integer> peoples = new LinkedHashMap<>();
        int peopleCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < peopleCount; i++) {
            String[] line = reader.readLine().split(", ");

            peoples.put(line[0], Integer.parseInt(line[1]));
        }

        String comparison = reader.readLine();
        int ageLimit = Integer.parseInt(reader.readLine());
        String printType = reader.readLine();

        peoples.entrySet().stream()
                .filter(person -> comparison.equals("younger") ?
                         youngerThen.test(person, ageLimit) :
                         olderThen.test(person, ageLimit))
        .forEach(person -> {
            switch (printType){
                case "age":
                    printAge.accept(person);
                    break;
                case "name":
                    printName.accept(person);
                    break;
                    default:
                        printNameAndAge.accept(person);
                        break;
            }
        });
    }
}
