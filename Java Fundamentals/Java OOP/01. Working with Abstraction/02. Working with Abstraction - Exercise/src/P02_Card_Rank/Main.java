package P02_Card_Rank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(reader.readLine() + ":");

        CardRank[] cardRanks = CardRank.values();

        for (CardRank cardRank : cardRanks) {
            System.out.println(String.format("Ordinal value: %d; Name value: %S",
                    cardRank.ordinal(), cardRank.toString()));
        }
    }
}
