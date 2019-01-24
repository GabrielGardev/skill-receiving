import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P05_Average_Student_Grades {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Map<String , List<Double>> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String [] line = reader.readLine().split(" ");
            String name = line[0];
            Double grade = Double.parseDouble(line[1]);

            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }

        students.forEach((key, value) -> {
            List<Double> temp = new ArrayList<>();
            System.out.printf("%s -> ", key);
            for (Double aDouble : value) {
                temp.add(aDouble);
                System.out.printf("%.2f ", aDouble);
            }
            double average = temp.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
            System.out.printf("(avg: %.2f)", average);
            System.out.println();
        });
    }
}
