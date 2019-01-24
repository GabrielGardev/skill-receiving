import java.util.*;
import java.util.stream.Collectors;

public class P4_Mixed_up_Lists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> firstNums = Arrays.stream(scanner.nextLine().split("\\s")).map(Double::parseDouble).collect(Collectors.toList());
        List<Double> secondNums = Arrays.stream(scanner.nextLine().split("\\s")).map(Double::parseDouble).collect(Collectors.toList());

        List<Double> result = new ArrayList<>();
        Double start, end;


        if (firstNums.size() > secondNums.size()) {
            for (int i = 0; i < secondNums.size(); i++) {
                result.add(firstNums.get(i));
                result.add(secondNums.get((secondNums.size() - 1) - i));
            }
            start = firstNums.get(firstNums.size() - 2);
            end = firstNums.get(firstNums.size() - 1);
        } else {
            for (int i = 0; i < firstNums.size(); i++) {
                result.add(firstNums.get(i));
                result.add(secondNums.get((secondNums.size() - 1) - i));
            }
            start = secondNums.get(0);
            end = secondNums.get(1);
        }

        if (end < start) {
            double temp = start;
            start = end;
            end = temp;
        }
        List<Double> result2 = new ArrayList<>();

        for (Double num : result) {

            if (num > start && num < end) {
                result2.add(num);
            }
        }
        Collections.sort(result2);
        result2.forEach(x -> System.out.print(fmt(x) + " "));
    }
    public static String fmt(double d)
    {
        if(d == (long) d)
            return String.format("%d",(long)d);
        else
            return String.format("%s",d);
    }
}
