import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P2_Car_Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        double leftRecerTime = 0;

        for (int i = 0; i < (numbers.size() - 1) / 2; i++) {
            int currentNum = numbers.get(i);
            if (currentNum == 0){
                leftRecerTime *= 0.8;
            }else {
                leftRecerTime += currentNum;
            }
        }

        double rightRecerTime = 0;
        for (int i = numbers.size() - 1; i > numbers.size() / 2; i--) {
            int currentNum = numbers.get(i);
            if (currentNum == 0){
                rightRecerTime *= 0.8;
            }else {
                rightRecerTime += currentNum;
            }
        }
        if (leftRecerTime > rightRecerTime){
            System.out.printf("The winner is right with total time: %.1f", rightRecerTime);
        }else {
            System.out.printf("The winner is left with total time: %.1f", leftRecerTime);
        }
    }
}
