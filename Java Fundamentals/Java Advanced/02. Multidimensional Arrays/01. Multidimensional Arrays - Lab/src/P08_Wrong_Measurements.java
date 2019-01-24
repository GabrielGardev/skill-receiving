import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P08_Wrong_Measurements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[][] startMatrix = new int[n][];

        for (int i = 0; i < n; i++) {
            int[] temp = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            startMatrix[i] = temp;
        }

        int[] coordinates = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int wrongNum = startMatrix[coordinates[0]][coordinates[1]];

        int[][] resultMatrix = new int[n][startMatrix[0].length];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < startMatrix[row].length; col++) {
                if (startMatrix[row][col] != wrongNum){
                    resultMatrix[row][col] = startMatrix[row][col];
                }else {
                    resultMatrix[row][col] = GetNewNumber(startMatrix, row, col, wrongNum);
                }
            }
        }
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < resultMatrix[0].length; col++) {
                System.out.print(resultMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int GetNewNumber(int[][] startMatrix, int row, int col, int wrongNum) {
        int sum = 0;

        //possible problem
        if (row - 1 >= 0 && startMatrix[row - 1][col] != wrongNum){
            sum += startMatrix[row - 1][col];
        }
        if (col + 1 < startMatrix[0].length && startMatrix[row][col + 1] != wrongNum){
            sum += startMatrix[row][col + 1];
        }

        if (row + 1 < startMatrix.length && startMatrix[row + 1][col] != wrongNum){
            sum += startMatrix[row + 1][col];
        }

        if (col - 1 >= 0 && startMatrix[row][col - 1] != wrongNum){
            sum += startMatrix[row][col - 1];
        }

        return sum;
    }
}
