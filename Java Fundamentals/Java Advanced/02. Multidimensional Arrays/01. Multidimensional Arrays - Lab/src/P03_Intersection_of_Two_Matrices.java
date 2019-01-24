import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P03_Intersection_of_Two_Matrices {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());

        char [][] matrix = new char[rows][cols];


        for (int i = 0; i < rows; i++) {
            String[] arr = reader.readLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                char currentChar = arr[j].charAt(0);
                matrix[i][j] = currentChar;
            }

        }

        for (int i = 0; i < rows; i++) {
            String [] arr = reader.readLine().split(" ");
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == arr[j].charAt(0)){
                    System.out.print(matrix[i][j] + " ");
                }else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
