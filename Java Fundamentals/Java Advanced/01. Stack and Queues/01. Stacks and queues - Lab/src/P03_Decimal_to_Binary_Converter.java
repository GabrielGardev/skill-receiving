import java.util.ArrayDeque;
import java.util.Scanner;

public class P03_Decimal_to_Binary_Converter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (num == 0){
            System.out.println(num);
            return;
        }

        while (num > 0){
            int reminder = num % 2;
            stack.push(reminder);

            num = num / 2;
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
