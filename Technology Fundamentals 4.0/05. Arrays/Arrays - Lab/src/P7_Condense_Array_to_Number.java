import java.util.Arrays;
import java.util.Scanner;

public class P7_Condense_Array_to_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        while (nums.length > 1)
        {
            int[] condensed = new int[nums.length - 1];

            for (int j = 0; j < condensed.length ; j++)
            {
                condensed[j] = nums[j] + nums[j + 1];
            }

            nums = condensed;

        }
        System.out.println(nums[0]);
    }
}
