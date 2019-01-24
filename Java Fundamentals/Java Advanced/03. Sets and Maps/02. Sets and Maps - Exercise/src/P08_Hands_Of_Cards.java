import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class P08_Hands_Of_Cards {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String , HashSet<String>> players = new LinkedHashMap<>();

        while (true){
            String [] line = reader.readLine().split(": ");
            if ("JOKER".equals(line[0])){
                break;
            }
            String name = line[0];
            HashSet<String> hand = Arrays.stream(line[1].split(", "))
                    .collect(Collectors.toCollection(HashSet::new));

            players.putIfAbsent(name, hand);
            players.get(name).addAll(hand);
        }
        for (var player : players.entrySet()) {
            int power = getPower(player.getValue());
            System.out.println(String.format("%s: %d", player.getKey(), power));
        }
    }

    private static int getPower(HashSet<String> card) {
        int power = 0;
        for (String s : card) {
            char currentChar = s.charAt(0);
            int currentPower = 0;

            switch (currentChar)
            {
                case 'A': currentPower = 14; break;
                case 'K': currentPower = 13; break;
                case 'Q': currentPower = 12; break;
                case 'J': currentPower = 11; break;
                case '1': currentPower = 10; break;


                default:
                    currentPower = Integer.parseInt(currentChar + "");
                    break;
            }
            char secondChar = s.charAt(s.length() - 1);
            switch (secondChar)
            {
                case 'S': currentPower *= 4; break;
                case 'H': currentPower *= 3; break;
                case 'D': currentPower *= 2; break;
            }
            power += currentPower;
        }
        return power;
    }
}
