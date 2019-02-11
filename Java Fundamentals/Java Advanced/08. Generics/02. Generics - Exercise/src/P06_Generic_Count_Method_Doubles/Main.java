package P06_Generic_Count_Method_Doubles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Box> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            double line = Double.parseDouble(reader.readLine());

            Box<Double> box = new Box<>(line);

            list.add(box);
        }

        double comparator = Double.parseDouble(reader.readLine());

        System.out.println(countGreaterThan(list, comparator));
    }

    private static int countGreaterThan(List<Box> list, double comparator) {
        int count = 0;
        for (Box box : list) {
            if (box.getValue().compareTo(comparator) > 0){
                count++;
            }
        }
        return count;
    }

}
