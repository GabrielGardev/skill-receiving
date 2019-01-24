import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P10_SoftUni_Exam_Results {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        HashMap<String, Integer> users = new HashMap<>();
        HashMap<String, Integer> submissions = new HashMap<>();

        while (!input.equals("exam finished")) {

            String[] tokens = input.split("-");
            if (tokens.length == 3) {
                String name = tokens[0], language = tokens[1];
                int points = Integer.parseInt(tokens[2]);
                if (!users.containsKey(name)) {
                    users.put(name, points);
                } else if (users.get(name) < points) {
                    users.put(name, points);
                }

                if (!submissions.containsKey(language)) {
                    submissions.put(language, 1);
                } else {
                    submissions.put(language, submissions.get(language) + 1);
                }
            } else {
                users.remove(tokens[0]);
            }

            input = scanner.nextLine();
        }

        System.out.println("Results:");

        users.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> {
                    System.out.println(String.format("%s | %d", entry.getKey(), entry.getValue()));
                });

        System.out.println("Submissions:");

        submissions.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue()
                .reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> {
                    System.out.println(String.format("%s - %d",
                            entry.getKey(), entry.getValue()));
                });
    }
}
