import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P6_Cards_Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPleyer = Arrays
                .stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondPleyer = Arrays
                .stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (firstPleyer.size() > 0 && secondPleyer.size() > 0){
            //firstPleyer win the hand
            if (firstPleyer.get(0) > secondPleyer.get(0)){
                firstPleyer.add(firstPleyer.get(0));
                firstPleyer.add(secondPleyer.get(0));
                firstPleyer.remove(0);
                secondPleyer.remove(0);
            }else if (secondPleyer.get(0) > firstPleyer.get(0)){
                secondPleyer.add(secondPleyer.get(0));
                secondPleyer.add(firstPleyer.get(0));
                secondPleyer.remove(0);
                firstPleyer.remove(0);
            }else {
                secondPleyer.remove(0);
                firstPleyer.remove(0);
            }
        }
        int sum = 0;
        if (firstPleyer.size() > secondPleyer.size()){
            sum = firstPleyer.stream().reduce((x, result) -> result + x).get();
            System.out.printf("First player wins! Sum: %d", sum);
        }else {
            sum = secondPleyer.stream().reduce((x, result) -> result + x).get();
            System.out.printf("Second player wins! Sum: %d", sum);

        }

    }
}
