import java.util.Scanner;

public class P6_Combinations_with_Repetition {
    public static String[] elements;
    public static String[] kSlots;
    public static int k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");
        k = Integer.parseInt(scanner.nextLine());
        kSlots = new String[k];

        combinations(0, 0);
    }

    private static void combinations(int index, int start) {
        if (index == k){
            print(kSlots);
        }else {
            for (int i = start; i < elements.length; i++) {
                kSlots[index] = elements[i];
                combinations(index + 1, i);
            }
        }
    }

    private static void print(String[] elements) {
        System.out.println(String.join(" ", elements));
    }
}
