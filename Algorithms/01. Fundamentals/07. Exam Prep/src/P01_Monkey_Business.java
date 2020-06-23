import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P01_Monkey_Business {
    public static int kSlots[];
    public static int k;
    public static int counter = 0;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(reader.readLine());
        kSlots = new int[k];

        combinations(0, 1);
        sb.append("Total Solutions: ").append(counter);
        System.out.println(sb.toString());
    }

    private static void combinations(int index, int start) {
        if (index == k) {
            if (Arrays.stream(kSlots).sum() == 0) {
                counter++;
                print();
            }
        } else {
            for (int i = start; i <= k; i++) {
                kSlots[index] = i;
                combinations(index + 1, i + 1);
                kSlots[index] = -i;
                combinations(index + 1, i + 1);
            }

        }
    }

    private static void print() {
        for (int element : kSlots) {
            if (element > 0){
                sb.append("+").append(element);
            }else {
                sb.append(element);
            }
            sb.append(" ");
        }
        sb.append(System.lineSeparator());
    }
}
