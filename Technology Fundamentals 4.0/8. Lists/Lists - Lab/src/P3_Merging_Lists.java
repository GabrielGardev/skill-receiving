import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P3_Merging_Lists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int biger = Math.max(firstList.size(), secondList.size());
        int lower = Math.min(firstList.size(), secondList.size());

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < lower; i++) {
                result.add(firstList.get(i));
                result.add(secondList.get(i));
        }

        int dif = biger - lower;
        if (firstList.size() > secondList.size()){
            for (int i = biger - dif; i < biger; i++) {
                result.add(firstList.get(i));
            }
        }else if (secondList.size() > firstList.size()){
            for (int i = biger - dif; i < biger; i++) {
                result.add(secondList.get(i));
            }
        }
        for (Integer item : result) {
            System.out.print(item  + " ");
        }
    }
}
