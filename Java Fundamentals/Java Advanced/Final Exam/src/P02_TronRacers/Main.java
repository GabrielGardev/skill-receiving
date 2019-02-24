package P02_TronRacers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] firstPos = new int[2];
    private static int[] secondPos = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        String[][] matrix = new String[n][n];

        fillMAtrix(matrix, n, reader);

        while (true) {
            String[] commands = reader.readLine().split("\\s+");

            String cmdFirst = commands[0];
            String cmdSecond = commands[1];

            if (!firstPlayerMove(matrix, cmdFirst)){
                break;
            }
            if (!secondPlayerMove(matrix, cmdSecond)){
                break;
            }
        }
        printMatrix(matrix);
    }
    private static void printMatrix(String[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean secondPlayerMove(String[][] matrix, String cmd) {
        boolean isHeAlive = true;

        switch (cmd){
            case "up":
                if (secondPos[0] - 1 < 0){
                    secondPos[0] = matrix.length - 1;
                }else {
                    secondPos[0]--;
                }
                break;
            case "right":
                if (secondPos[1] + 1 >= matrix[0].length){
                    secondPos[1] = 0;
                }else {
                    secondPos[1]++;
                }
                break;
            case "left":
                if (secondPos[1] - 1 < 0){
                    secondPos[1] = matrix[0].length - 1;
                }else {
                    secondPos[1]--;
                }
                break;
            case "down":
                if (secondPos[0] + 1 >= matrix.length){
                    secondPos[0] = 0;
                }else {
                    secondPos[0]++;
                }
                break;
        }
        if (matrix[secondPos[0]][secondPos[1]].equals("f")){
            matrix[secondPos[0]][secondPos[1]] = "x";
            isHeAlive = false;
        }else {
            matrix[secondPos[0]][secondPos[1]] = "s";
        }
        return isHeAlive;
    }

    private static boolean firstPlayerMove(String[][] matrix, String cmd) {
        boolean isHeAlive = true;

        switch (cmd){
            case "up":
                if (firstPos[0] - 1 < 0){
                    firstPos[0] = matrix.length - 1;
                }else {
                    firstPos[0]--;
                }
                break;
            case "right":
                if (firstPos[1] + 1 >= matrix[0].length){
                    firstPos[1] = 0;
                }else {
                    firstPos[1]++;
                }
                break;
            case "left":
                if (firstPos[1] - 1 < 0){
                    firstPos[1] = matrix[0].length - 1;
                }else {
                    firstPos[1]--;
                }
                break;
            case "down":
                if (firstPos[0] + 1 >= matrix.length){
                    firstPos[0] = 0;
                }else {
                    firstPos[0]++;
                }
                break;
        }
        if (matrix[firstPos[0]][firstPos[1]].equals("s")){
            matrix[firstPos[0]][firstPos[1]] = "x";
            isHeAlive = false;
        }else {
            matrix[firstPos[0]][firstPos[1]] = "f";
        }
        return isHeAlive;
    }

    private static void fillMAtrix(String[][] matrix, int n, BufferedReader reader) throws IOException {
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("");
            for (int j = 0; j < line.length; j++) {
                if (line[j].equals("f")){
                    firstPos[0] = i;
                    firstPos[1] = j;
                }else if (line[j].equals("s")){
                    secondPos[0] = i;
                    secondPos[1] = j;
                }
                matrix[i][j] = line[j];
            }
        }
    }
}
