import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P02_Positions_Of {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = reader.readLine().split(" ");
        int rows = Integer.parseInt(nums[0]);
        int cols = Integer.parseInt(nums[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = arr;
        }

        int numToFind = Integer.parseInt(reader.readLine());
        boolean isFind = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == numToFind){
                    System.out.println(i + " " + j);
                    isFind = true;
                }
            }
        }
        if (!isFind){
            System.out.println("not found");
        }
    }
}
