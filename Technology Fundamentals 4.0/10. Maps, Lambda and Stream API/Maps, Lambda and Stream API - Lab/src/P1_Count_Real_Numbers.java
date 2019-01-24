import java.lang.reflect.Array;
        import java.text.DecimalFormat;
        import java.util.*;
        import java.util.stream.Collectors;

public class P1_Count_Real_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());

        Map<Double, Integer> result = new TreeMap<>();

        for (Double number : numbers) {
            if (result.containsKey(number) == false) {
                result.put(number, 0);
            }
            result.put(number , result.get(number) + 1);
        }

        for (var entry : result.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.#######");
            System.out.printf("%s -> %d",df.format(entry.getKey()), entry.getValue());
            System.out.println();
        }
    }
}
