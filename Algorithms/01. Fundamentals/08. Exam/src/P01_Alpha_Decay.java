import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P01_Alpha_Decay {
    public static int[] kSlots;
    public static int n;
    public static int[] elements;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        elements = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        visited = new boolean[elements.length];
        n = Integer.parseInt(reader.readLine());
        kSlots = new int[n];

        variations(0);
    }

    private static void variations(int index) {
        if (index == n){
            print(kSlots);
        }else {
            for (int i = 0; i < elements.length; i++) {
                if (!visited[i]){
                    visited[i] = true;
                    kSlots[index] = elements[i];
                    variations(index + 1);
                    visited[i] = false;
                }
            }
        }
    }

    private static void print(int[] elements) {
        for (int element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
