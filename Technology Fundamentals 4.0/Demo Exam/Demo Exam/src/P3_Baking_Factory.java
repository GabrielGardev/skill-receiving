import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P3_Baking_Factory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> bestBatch = new ArrayList<>();
        int bestQuality = Integer.MIN_VALUE;
        int bestAverage = Integer.MIN_VALUE;
        int bestLen = 0;

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Bake It!")) {
                break;
            }
            List<Integer> currentBatch = Arrays.stream(input.split("#")).map(Integer::parseInt).collect(Collectors.toList());

            int currentQuality = currentBatch.stream().reduce((result , x) -> result + x).get();
//            for (int i = 0; i < currentBatch.size(); i++) {
//                currentQuality += currentBatch.get(i);
//            }

            int currentAverage = 0;

            for (int i = 0; i < currentBatch.size(); i++) {
                currentAverage += currentBatch.get(i);
            }

            currentAverage /= currentBatch.size();


            if (currentQuality > bestQuality) {
                bestQuality = currentQuality;
                bestAverage = currentAverage;
                bestBatch = currentBatch;
                bestLen = currentBatch.size();

            } else if (currentQuality == bestQuality) {

                if (currentAverage > bestAverage) {
                    bestAverage = currentAverage;
                    bestBatch = currentBatch;
                    bestLen = currentBatch.size();

                } else if (currentAverage == bestAverage){

                    if (currentBatch.size() < bestLen){
                        bestBatch = currentBatch;
                        bestLen = currentBatch.size();
                    }
                }
            }
        }
        System.out.println("Best Batch quality: " + bestQuality);
        bestBatch.forEach(x -> System.out.print(x + " "));
    }
}
