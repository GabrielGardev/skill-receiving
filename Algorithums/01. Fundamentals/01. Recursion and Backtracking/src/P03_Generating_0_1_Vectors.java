import java.util.Scanner;

public class P03_Generating_0_1_Vectors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] vector = new int[n];

        generateVector(vector, 0);
    }

    private static void generateVector(int[] vector, int index) {
        if (index > vector.length - 1){
            printVector(vector);
            return;
        }

        for (int i = 0; i <= 1; i++) {
            vector[index] = i;
            generateVector(vector, index + 1);
        }
    }

    private static void printVector(int[] vector) {
        for (int value : vector) {
            System.out.print(value);
        }
        System.out.println();
    }
}
