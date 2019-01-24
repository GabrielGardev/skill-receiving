import java.util.Scanner;
        import java.util.TreeMap;

public class P3_MOBA_Challenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, TreeMap<String, Integer>> tire = new TreeMap<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Season end")) {
                break;
            }
            if (input.contains(" -> ")) {
                String[] line = input.split(" -> ");
                String player = line[0];
                String position = line[1];
                int skill = Integer.parseInt(line[2]);

                if (tire.containsKey(player) == false) {
                    tire.put(player, new TreeMap<>());
                }
                if (tire.get(player).containsKey(position)) {
                    if (tire.get(player).get(position) < skill) {
                        tire.get(player).put(position, skill);
                    }
                } else {
                    tire.get(player).put(position, skill);
                }
            } else {
                String[] line = input.split(" vs ");
                String player1 = line[0];
                String player2 = line[1];

                boolean samePosition = false;
                if (tire.containsKey(player1) && tire.containsKey(player2)) {
                    for (var pos : tire.get(player1).keySet()) {
                        for (var pos2 : tire.get(player2).keySet()) {
                            if (pos.equals(pos2)) {
                                samePosition = true;
                                break;
                            }
                        }
                    }
                    if (samePosition) {
                        int sumPlayer1 = 0;
                        int sumPlayer2 = 0;
                        for (var duelist : tire.get(player1).values()) {
                            sumPlayer1 += duelist;
                        }
                        for (var value : tire.get(player2).values()) {
                            sumPlayer2 += value;
                        }
                        if (sumPlayer1 > sumPlayer2) {
                            tire.remove(player2);
                        } else if (sumPlayer2 > sumPlayer1) {
                            tire.remove(player1);
                        }
                    }
                }
            }
        }
        tire.entrySet()
                .stream()
                .sorted((a, b) -> {
                    int sum1 = 0;
                    int sum2 = 0;

                    for (var player : a.getValue().values()) {
                        sum1 += player;
                    }
                    for (var player : b.getValue().values()) {
                        sum2 += player;
                    }
                    return Integer.compare(sum2, sum1);
                })
                .forEach(x -> {
                    int sum = 0;
                    for (var player : x.getValue().values()){
                        sum += player;
                    }
                    System.out.printf("%s: %d skill%n",x.getKey(), sum);

                    x.getValue()
                            .entrySet()
                            .stream()
                            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                            .forEach(p -> {
                                System.out.printf("- %s <::> %d%n", p.getKey(), p.getValue());
                            });
                });
    }
}
