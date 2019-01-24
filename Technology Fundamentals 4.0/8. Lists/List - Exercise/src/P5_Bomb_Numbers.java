import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P5_Bomb_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> specialNum = Arrays
                .stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = 0;
        int range = specialNum.get(1);

        while (numbers.contains(specialNum.get(0)))
        {
            int bomb = numbers.indexOf(specialNum.get(0));
            if (bomb - range >= 0)
            {
                bomb = bomb - range;
            }
            else
            {
                bomb = 0;
            }

            if (bomb + (2 * range + 1) >= numbers.size())
            {
                numbers.subList(bomb , numbers.size()).clear();
            }
            else
            {
                numbers.subList(bomb, bomb + (2 * range + 1)).clear();
            }
        }
        if (numbers.isEmpty()){
            System.out.println("0");
            return;
        }
        sum = numbers.stream().reduce((x, result) -> result + x).get();
        System.out.println(sum);
    }
}
