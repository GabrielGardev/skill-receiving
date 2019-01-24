import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01_Fill_the_Matrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String [] input = reader.readLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String type = input[1];

        int[][] matrix = new int[n][n];

        if (type.equals("A")){
            matrix = getMatrixFromTypeA(n);
        }else if (type.equals("B")){
            matrix = getMatrixFromTypeB(n);
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }

    private static int[][] getMatrixFromTypeB(int n) {
        int[][] matrix = new int[n][n];
        int finalNum = n * n;

        for (int i = 1; i <= finalNum; i++) {

            for (int col = 0; col < n; col++) {
                if (col % 2 == 0){
                    for (int row = 0; row < n; row++) {
                        matrix[row][col] = i;
                        i++;
                    }
                }else {
                    for (int row = n - 1; row >= 0; row--) {
                        matrix[row][col] = i;
                        i++;
                    }
                }
            }
        }

        return matrix;
    }

    private static int[][] getMatrixFromTypeA(int n) {
        int[][] matrix = new int[n][n];

        int finalNum = n * n;

        for (int i = 1; i <= finalNum; i++) {

            for (int col = 0; col < n; col++) {
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = i;
                    i++;
                }
            }
        }

        return matrix;
    }
}
