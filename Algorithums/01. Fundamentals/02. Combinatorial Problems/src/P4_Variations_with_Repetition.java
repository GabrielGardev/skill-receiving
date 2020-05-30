import java.util.Scanner;

public class P4_Variations_with_Repetition {
    public static String[] elements;
    public static String[] kSlots;
    public static int k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");
        k = Integer.parseInt(scanner.nextLine());
        kSlots = new String[k];

        variations(0);
    }

    private static void variations(int index) {
        if (index >= k){
            print(kSlots);
        }else {
            for (String element : elements) {
                kSlots[index] = element;
                variations(index + 1);
            }
        }
    }

    private static void print(String[] elements) {
        System.out.println(String.join(" ", elements));
    }
}
