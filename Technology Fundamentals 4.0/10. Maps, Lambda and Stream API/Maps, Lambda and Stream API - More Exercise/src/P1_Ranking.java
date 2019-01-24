import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class P1_Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contestsAndPasswords = new HashMap<>();
        TreeMap<String, LinkedHashMap<String, Integer>> students = new TreeMap<>();
        while (true) {
            String[] line = scanner.nextLine().split(":");
            if (line[0].equals("end of contests")) {
                break;
            }
            String contest = line[0];
            String password = line[1];

            contestsAndPasswords.put(contest, password);
        }

        while (true) {
            String[] line = scanner.nextLine().split("=>");
            if (line[0].equals("end of submissions")) {
                break;
            }
            String contest = line[0];
            String password = line[1];
            String userName = line[2];
            int points = Integer.parseInt(line[3]);

            if (!contestsAndPasswords.containsKey(contest) || !contestsAndPasswords.get(contest).contains(password)) {
                continue;
            }

            if (students.containsKey(userName) == false) {
                students.put(userName, new LinkedHashMap<>());
            }
            if (students.containsKey(userName) && students.get(userName).containsKey(contest)) {
                if (students.get(userName).get(contest) < points) {
                    students.get(userName).put(contest, points);
                }
                continue;
            }
            students.get(userName).put(contest, points);
        }
        int[] max = new int[1];
        String[] name = new String[1];

        students.forEach((key, value) -> {
            int[] sum = {0};
            value.forEach((str, inter) -> {
                sum[0] += inter;
            });
            if (sum[0] > max[0]) {
                max[0] = sum[0];
                name[0] = key;
            }
        });
        System.out.printf("Best candidate is %s with total %d points.%n", name[0], max[0]);
        System.out.println("Ranking: ");

        students.forEach((key, value) -> {
            System.out.printf("%s%n", key);
            value.entrySet()
                    .stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .forEach(x -> {
                        System.out.printf("#  %s -> %d%n", x.getKey(), x.getValue());
                    });

        });

    }
}
