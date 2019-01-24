import java.lang.reflect.Array;
        import java.util.*;

public class P7_Student_Academy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, ArrayList<Double>> students = new LinkedHashMap<>();
        Map<String, Double> average = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());


            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }
        for (String s : students.keySet()) {
            double sum = 0;
            for (int i = 0; i < students.get(s).size(); i++) {
                sum += students.get(s).get(i);
            }
            sum /= students.get(s).size();
            average.putIfAbsent(s , 0.0);
            average.put(s, sum);
        }

        average.entrySet().stream()
                .filter(x -> x.getValue() >= 4.50)
                .sorted((a,b) -> b.getValue().compareTo(a.getValue()))
                .forEach(x -> System.out.printf("%s -> %.2f%n",x.getKey(),x.getValue()));
    }
}
