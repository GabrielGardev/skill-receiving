import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P07_Find_The_Real_Queen {
    private static int SIZE = 8;
    private static Character QUEEN = 'q';
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char [][] matrix = new char[8][8];


        for (int i = 0; i < SIZE; i++) {
            String[] arr = reader.readLine().split(" ");
            for (int j = 0; j < SIZE; j++) {
                char currentChar = arr[j].charAt(0);
                matrix[i][j] = currentChar;
            }
        }
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (matrix[row][col] == QUEEN){
                    if (isItValidQueen(row, col, matrix)){
                        System.out.println(row + " " + col);
                        return;
                    }
                }
            }
        }
    }

    private static boolean isItValidQueen(int row, int col, char[][] matrix) {
       return isQueenRowValid(row, matrix) &&
        isQueenColValid(col, matrix) &&
        isQueenFirstVerticalValid(row, col, matrix) &&
        isQueenSecondVerticalValid(row, col, matrix);
    }

    private static boolean isQueenSecondVerticalValid(int row, int col, char[][] matrix) {
        int queensCount = 0;

        for (int i = 1; row - i >= 0 && col + i < SIZE; i++) {
            if (matrix[row - i][col + i] == QUEEN){
                queensCount++;
            }
        }

        for (int i = 1; row + i < SIZE && col - i >= 0; i++) {
            if (matrix[row + i][col - i] == QUEEN){
                queensCount++;
            }
        }
        return queensCount == 0;
    }

    private static boolean isQueenFirstVerticalValid(int row, int col, char[][] matrix) {
        int queensCount = 0;

        for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
            if (matrix[row - i][col - i] == QUEEN){
                queensCount++;
            }
        }

        for (int i = 1; row + i < SIZE && col + i < SIZE; i++) {
            if (matrix[row + i][col + i] == QUEEN){
                queensCount++;
            }
        }
        return queensCount == 0;
    }

    private static boolean isQueenColValid(int col, char[][] matrix) {
        int queensCount = 0;

        for (int i = 0; i < SIZE; i++) {
            if (matrix[i][col] == QUEEN){
                queensCount++;
            }
        }
        return queensCount == 1;
    }

    private static boolean isQueenRowValid(int row, char[][] matrix) {
        int queensCount = 0;

        for (int i = 0; i < SIZE; i++) {
            if (matrix[row][i] == QUEEN){
                queensCount++;
            }
        }
        return queensCount == 1;
    }
}
