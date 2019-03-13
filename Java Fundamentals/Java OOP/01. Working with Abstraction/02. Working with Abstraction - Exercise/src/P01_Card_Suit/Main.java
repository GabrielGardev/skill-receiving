package P01_Card_Suit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(reader.readLine() + ":");

        CardSuit[] cardSuits = CardSuit.values();

        for (CardSuit cardSuit : cardSuits) {
            System.out.println(String.format("Ordinal value: %d; Name value: %S",
                    cardSuit.ordinal(), cardSuit.toString()));
        }
    }
}
