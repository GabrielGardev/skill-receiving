import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class P6_Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> program = new LinkedHashMap<>();

        while (true) {
            String[] line = scanner.nextLine().split(" : ");
            if (line[0].equals("end")) {
                break;
            }
            String course = line[0];
            String student = line[1];

            program.putIfAbsent(course, new ArrayList<>());
            program.get(course).add(student);
        }

        program.entrySet().stream()
                .sorted((a , b) -> b.getValue().size() - a.getValue().size())
                .forEach(x -> {
                    System.out.printf("%s: %d%n", x.getKey(), x.getValue().size());
                    x.getValue().stream().sorted().forEach(s -> System.out.println("-- " + s));
                });


    }
}
