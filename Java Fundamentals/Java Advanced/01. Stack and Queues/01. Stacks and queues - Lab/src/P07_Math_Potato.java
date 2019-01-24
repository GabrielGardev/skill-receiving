import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P07_Math_Potato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> kids = new ArrayDeque<>();
        int round = 1;

        Collections.addAll(kids, names);

        while (kids.size() > 1){
            for (int i = 0; i < n - 1; i++) {
                String currentKid = kids.poll();
                kids.offer(currentKid);
            }
            if (checkIsPrime(round)) {
                System.out.println("Prime " + kids.peek());
            }else {
                System.out.println("Removed " + kids.poll());
            }
            round++;
        }

        System.out.println("Last is " + kids.poll());

    }
    private static boolean checkIsPrime(int number) {
        boolean isPrime = true;

        if (number < 2) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        return isPrime;
    }
}
