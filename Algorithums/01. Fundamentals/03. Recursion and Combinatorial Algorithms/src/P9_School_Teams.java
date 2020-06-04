import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P9_School_Teams {
    public static int GIRLS_SLOTS = 3;
    public static int BOYS_SLOTS = 2;

    public static List<String[]> g = new ArrayList<>();
    public static List<String[]> b = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] girls = reader.readLine().split(", ");
        String[] boys = reader.readLine().split(", ");

        String[] gSlots = new String[GIRLS_SLOTS];
        String[] bSlots = new String[BOYS_SLOTS];

        comb(0, 0, girls, gSlots, g);
        comb(0, 0, boys, bSlots, b);

        print();
    }

    private static void comb(int index, int start, String[] team, String[] actual, List<String[]> result) {
        if (index >= actual.length) {
            result.add(actual.clone());
        } else {
            for (int i = start; i < team.length; i++) {
                actual[index] = team[i];
                comb(index + 1, i + 1,team, actual, result);
            }
        }
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (String[] girlGroup : g) {
            for (String[] BoyGroup : b) {
                sb.append(String.join(", ", girlGroup)).append(", ")
                    .append(String.join(", ", BoyGroup)).append(System.lineSeparator());
            }
        }
        System.out.println(sb.toString().trim());
    }
}
