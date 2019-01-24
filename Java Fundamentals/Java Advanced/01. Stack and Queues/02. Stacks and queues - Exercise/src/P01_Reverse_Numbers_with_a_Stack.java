import java.util.ArrayDeque;
import java.util.Scanner;

public class P01_Reverse_Numbers_with_a_Stack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nums = scanner.nextLine().split("\\s+");

        ArrayDeque<String> reversOrder = new ArrayDeque<>();
        for (String num : nums) {
            reversOrder.push(num);
        }

        while (!reversOrder.isEmpty()){
            System.out.print(reversOrder.pop() + " ");
        }
    }
}
