package P04_Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> lake = Arrays.stream(reader.readLine().split(", "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        Lake<Integer> lake1 = new Lake(lake);

        StringBuilder sb = new StringBuilder();
        for (Integer o : lake1) {
            sb.append(o).append(", ");
        }

        System.out.println(sb.toString().substring(0, sb.lastIndexOf(",")));
    }
}
