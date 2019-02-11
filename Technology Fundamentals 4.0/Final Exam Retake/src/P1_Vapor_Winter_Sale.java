import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1_Vapor_Winter_Sale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> gamesPrices = new HashMap<>();
        Map<String, String>gamesDLC = new HashMap<>();

        String[] line = scanner.nextLine().split(", ");

        for (String s : line) {
            if (s.contains("-")){
                String [] input = s.split("-");
                String game = input[0];
                double price = Double.parseDouble(input[1]);

                gamesPrices.put(game, price);
            }else if (s.contains(":")){
                String [] input = s.split(":");
                String game = input[0];
                String DLC = input[1];

                if (gamesPrices.containsKey(game)){
                    gamesDLC.put(game, DLC);

                    double newPrice = gamesPrices.get(game) + (gamesPrices.get(game) * 0.2);

                    gamesPrices.put(game, newPrice);
                }
            }
        }
        for (Map.Entry<String, Double> entry : gamesPrices.entrySet()) {
            if (gamesDLC.containsKey(entry.getKey())){
                double newPrice = entry.getValue() - (entry.getValue() * 0.5);
                gamesPrices.put(entry.getKey(), newPrice);
            }else {
                double newPrice = entry.getValue() - (entry.getValue() * 0.2);
                gamesPrices.put(entry.getKey(), newPrice);
            }
        }
        gamesPrices.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(x -> {
                    if (gamesDLC.containsKey(x.getKey())){
                        System.out.println(String.format("%s - %s - %.2f", x.getKey(), gamesDLC.get(x.getKey()), x.getValue()));
                    }
                });
        gamesPrices.entrySet().stream()
                .sorted((a,b) -> b.getValue().compareTo(a.getValue()))
                .forEach(x -> {
                    if (!gamesDLC.containsKey(x.getKey())){
                        System.out.println(String.format("%s - %.2f", x.getKey(), x.getValue()));
                    }
                });
    }
}
