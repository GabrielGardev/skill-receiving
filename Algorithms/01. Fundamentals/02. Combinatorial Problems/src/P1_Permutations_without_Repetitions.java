import java.util.Scanner;

public class P1_Permutations_without_Repetitions {

    public static String[] elements;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");
        permute(0);
    }

    private static void permute(int index) {
        if (index >= elements.length){
            print(elements);
        }else {
            permute(index + 1);
            for (int i = index + 1; i < elements.length; i++) {
                swap(index, i);
                permute(index + 1);
                swap(index, i);
            }
        }
    }

    private static void print(String[] elements) {
        System.out.println(String.join(" ", elements));
    }

    private static void swap(int first, int second){
        String temp = elements[first];
        elements[first] = elements[second];
        elements[second] = temp;
    }
}
