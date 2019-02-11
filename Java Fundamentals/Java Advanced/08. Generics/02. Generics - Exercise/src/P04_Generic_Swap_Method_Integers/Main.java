package P04_Generic_Swap_Method_Integers;

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
            int line = Integer.parseInt(reader.readLine());

            Box<Integer> box = new Box<>(line);

            list.add(box);
        }

        String[] elementsForSwap = reader.readLine().split(" ");
        int first = Integer.parseInt(elementsForSwap[0]);
        int second = Integer.parseInt(elementsForSwap[1]);

        swapElements(list, first, second);

        for (var s : list) {
            System.out.println(s.toString());
        }
    }
    public static void swapElements (List list, int first, int second){

        list.set(first, list.set(second, list.get(first)));

    }
}
