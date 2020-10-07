import java.util.Arrays;

public class NumberZooPatrol {
    public static void main(String[] args) {
        System.out.println(findMissingNumber(new int[] {13, 11, 10, 3, 2, 1, 4, 5, 6, 9, 7, 8}));
    }

    public static int findMissingNumber(int[] numbers) {
        long sum = Arrays.stream(numbers).sum();
        long n = numbers.length + 1;
        long sum2 = n * (n + 1) / 2;
        return (int) (sum2 - sum);
    }

//    public static int findMissingNumber(int[] numbers) {
//        return IntStream.rangeClosed(1,numbers.length+1).sum() - Arrays.stream(numbers).sum();
//    }
}
