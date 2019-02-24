package P02_Sneaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int[] nikoladzePos = new int[2];
    private static int[] samPos = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<List<String>> matrix = new ArrayList<>();
        fillMatrix(matrix, n, reader);

        String[] commands = reader.readLine().split("");

        for (String command : commands) {
            enemyMove(matrix);

            if (isSamDead(matrix)){
                matrix.get(samPos[0]).set(samPos[1], "X");
                System.out.println(String.format("Sam died at %d, %d", samPos[0], samPos[1]));
                printMatrix(matrix);
                return;
            }

            samMove(command);

            if (matrix.get(samPos[0]).get(samPos[1]).equals("b") || matrix.get(samPos[0]).get(samPos[1]).equals("d")){
                matrix.get(samPos[0]).set(samPos[1], ".");
            }else if (samPos[0] == nikoladzePos[0]){
                matrix.get(nikoladzePos[0]).set(nikoladzePos[1], "X");
                matrix.get(samPos[0]).set(samPos[1], "S");

                System.out.println("Nikoladze killed!");
                printMatrix(matrix);
                return;
            }
        }
    }

    private static void samMove(String command) {
        switch (command){
            case "U":
                samPos[0]--;
                break;
            case "D":
                samPos[0]++;
                break;
            case "R":
                samPos[1]++;
                break;
            case "L":
                samPos[1]--;
                break;
                default:
                    break;
        }
    }

    private static boolean isSamDead(List<List<String>> matrix) {
        if (matrix.get(samPos[0]).contains("b")){
            int col = matrix.get(samPos[0]).indexOf("b");
            return col < samPos[1];
        }else if (matrix.get(samPos[0]).contains("d")){
            int col = matrix.get(samPos[0]).indexOf("d");
            return col > samPos[1];
        }
        return false;
    }

    private static void printMatrix(List<List<String >> matrix) {

        for (List<String> list : matrix) {
            System.out.println(String.join("",list));
        }
    }

    private static void enemyMove(List<List<String>> matrix) {
        for (List<String> matrix1 : matrix) {
            if (matrix1.contains("b")) {
                int col = matrix1.indexOf("b");

                if (col + 1 >= matrix1.size()) {
                    matrix1.set(col, "d");
                } else {
                    matrix1.set(col, ".");
                    matrix1.set(col + 1, "b");
                }
            } else if (matrix1.contains("d")) {
                int col = matrix1.indexOf("d");

                if (col - 1 < 0) {
                    matrix1.set(col, "b");
                } else {
                    matrix1.set(col, ".");
                    matrix1.set(col - 1, "d");
                }
            }
        }
    }

    private static void fillMatrix(List<List<String>> matrix, int rows, BufferedReader reader) throws IOException {
        for (int i = 0; i < rows; i++) {
            matrix.add(i, new ArrayList<>());
            String[] line = reader.readLine().split("");
            for (int j = 0; j < line.length; j++) {
                if (line[j].equals("N")){
                    nikoladzePos[0] = i;
                    nikoladzePos[1] = j;
                }else if (line[j].equals("S")){
                    samPos[0] = i;
                    samPos[1] = j;
                    line[j] = ".";
                }
                matrix.get(i).add(line[j]);
            }
        }
    }
}
