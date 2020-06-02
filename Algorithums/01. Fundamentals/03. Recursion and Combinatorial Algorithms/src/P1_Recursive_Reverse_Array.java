import java.util.Scanner;

public class P1_Recursive_Reverse_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elements = scanner.nextLine().split(" ");
        printNumbs(elements, elements.length - 1);
    }

    private static void printNumbs(String[] elements, int index) {
        if (index < 0){return;}

        System.out.print(String.format("%s ", elements[index]));
        printNumbs(elements, index - 1);
    }
}
