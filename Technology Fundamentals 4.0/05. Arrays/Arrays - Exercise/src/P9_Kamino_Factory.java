import java.util.Arrays;
import java.util.Scanner;

public class P9_Kamino_Factory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lenghtOfTheSequences = Integer.parseInt(scanner.nextLine());

        int bestLength = 0;
        int bestIndex = 0;
        String theBestSequences = "";
        int sample = 0;
        int bestSum = 0;
        int counter = 0;


        while (true) {
            String input = scanner.nextLine();

            if (input.equals("Clone them!")) {
                break;
            }
            counter++;

            String sequences = input.replaceAll("!", "");

            String[] dnas = sequences.split("0");
            int sum = 0;
            int maxLength = 0;
            String bestLocalDna = "";
            for (int i = 0; i < dnas.length; i++) {
                if (dnas[i].length() > maxLength) {
                    maxLength = dnas[i].length();
                    bestLocalDna = dnas[i];
                }
                sum += dnas[i].length();
            }

            int startIndex = sequences.indexOf(bestLocalDna);

            if (maxLength > bestLength) {
                bestLength = maxLength;
                theBestSequences = sequences;
                bestIndex = startIndex;
                bestSum = sum;
                sample = counter;
            } else if (maxLength == bestLength && (startIndex < bestIndex || sum > bestSum)) {
                bestLength = maxLength;
                theBestSequences = sequences;
                bestIndex = startIndex;
                bestSum = sum;
                sample = counter;
            } else if (counter == 1){
                bestLength = maxLength;
                theBestSequences = sequences;
                bestIndex = startIndex;
                bestSum = sum;
                sample = counter;
            }
        }
        System.out.printf("Best DNA sample %d with sum: %d.\n", sample, bestSum);

        for (int i = 0; i < theBestSequences.length(); i++) {
            System.out.print(theBestSequences.charAt(i) + " ");
        }
    }
}
