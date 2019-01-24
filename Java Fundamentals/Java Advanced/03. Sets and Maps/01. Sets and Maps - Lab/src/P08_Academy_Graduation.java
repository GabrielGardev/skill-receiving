import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

import static java.math.MathContext.DECIMAL64;

public class P08_Academy_Graduation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Map<String , String> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = reader.readLine();
            List<Double> grades = Arrays.stream(reader.readLine().split(" "))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());

            double avr = 0;
            for (Double grade : grades) {
                avr += grade;
            }
            students.putIfAbsent(name, String.valueOf(avr / grades.size()));
        }
        students.forEach((key, value) -> {

            System.out.println(String.format("%s is graduated with %s", key, value));
        });
    }
}
