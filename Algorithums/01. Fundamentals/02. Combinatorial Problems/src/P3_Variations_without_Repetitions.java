import java.util.Scanner;

public class P3_Variations_without_Repetitions {
    public static String[] elements;
    public static String[] kSlots;
    public static boolean[] used;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");
        int slots = Integer.parseInt(scanner.nextLine());
        kSlots = new String[slots];
        used = new boolean[elements.length];

        variations(0);
    }

    private static void variations(int index) {
        if (index >= kSlots.length){
            print(kSlots);
        }else {
            for (int i = 0; i < elements.length; i++) {
                if (!used[i]){
                    used[i] = true;
                    kSlots[index] = elements[i];
                    variations(index + 1);
                    used[i] = false;
                }
            }
        }
    }

    private static void print(String[] elements) {
        System.out.println(String.join(" ", elements));
    }
}
