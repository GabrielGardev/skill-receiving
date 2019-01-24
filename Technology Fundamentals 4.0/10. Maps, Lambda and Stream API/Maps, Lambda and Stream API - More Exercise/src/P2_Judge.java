import java.util.*;

public class P2_Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, TreeMap<String, Integer>> contests = new LinkedHashMap<>();
        TreeMap<String, Integer> topStudents = new TreeMap<>();
        while (true) {
            String[] line = scanner.nextLine().split(" -> ");
            if (line[0].equals("no more time")) {
                break;
            }
            String userName = line[0];
            String contest = line[1];
            int points = Integer.parseInt(line[2]);

            if (!contests.containsKey(contest)) {
                contests.put(contest, new TreeMap<>());
            }
            if (contests.get(contest).containsKey(userName)) {
                if (contests.get(contest).get(userName) < points) {
                    contests.get(contest).put(userName, points);
                }
            } else {
                contests.get(contest).put(userName, points);
            }

            topStudents.put(userName, 0);
        }
        for (String s : topStudents.keySet()) {
            for (var value : contests.values()) {
                if (value.containsKey(s)){
                    topStudents.put(s, topStudents.get(s) + value.get(s));
                }
            }
        }

        contests.forEach((key, value) -> {
            System.out.printf("%s: %d participants%n", key, value.size());
            final int[] num = {1};
            value
                    .entrySet()
                    .stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .forEach(v -> {
                        System.out.printf("%d. %s <::> %d%n", num[0], v.getKey(), v.getValue());
                        num[0]++;
                    });
        });
        System.out.println("Individual standings: ");
        final int[] num = {1};
        topStudents.entrySet()
                .stream()
                .sorted((a,b) -> b.getValue().compareTo(a.getValue()))
                .forEach(x -> {
                    System.out.printf("%d. %s -> %d%n", num[0], x.getKey(), x.getValue());
                    num[0]++;
                });
    }
}
