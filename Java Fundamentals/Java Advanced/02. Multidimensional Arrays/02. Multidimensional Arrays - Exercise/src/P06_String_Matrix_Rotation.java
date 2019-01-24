import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P06_String_Matrix_Rotation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = reader.readLine().split("\\(");
        int degree = Integer.parseInt(firstLine[1].substring(0, firstLine[1].length() - 1));

        int realRotate = (degree / 90) % 4;

        List<String> allLines = new ArrayList<>();
        int maxLength = 0;
        while (true) {
            String line = reader.readLine();
            if ("END".equals(line)) {
                break;
            }
            allLines.add(line);

            if (line.length() > maxLength) {
                maxLength = line.length();
            }
        }

        char[][] matrix = new char[allLines.size()][maxLength];

        switch (realRotate) {
            //0 , 360 degree
            case 0:
                matrix = fillMatrix0(allLines, maxLength);
                break;
            //90 degree
            case 1:
                matrix = fillMatrix90(allLines, maxLength);
                break;
            //180 degree
            case 2:
                matrix = fillMatrix180(allLines, maxLength);
                break;
            //270 degree
            case 3:
                matrix = fillMatrix270(allLines, maxLength);
                break;
        }
        printMatrix(matrix);
    }

    private static char[][] fillMatrix270(List<String> allLines, int maxLength) {
        int rows = maxLength;
        int cols = allLines.size();
        char[][] matrix = new char[rows][cols];

        for (int col = 0; col < cols; col++) {
            String word = allLines.get(col);
            for (int row = rows - 1; row >= 0; row--) {
                char currentChar;
                try {
                    currentChar = word.charAt(row);
                } catch (Exception e) {
                    currentChar = ' ';
                }
                matrix[rows - 1 - row][col] = currentChar;
            }
        }

        return matrix;
    }

    private static char[][] fillMatrix180(List<String> allLines, int maxLength) {
        int rows = allLines.size();
        int cols = maxLength;
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String word = allLines.get(allLines.size() - 1 - row);
            for (int col = cols - 1; col >= 0; col--) {
                char currentChar;
                try {
                    currentChar = word.charAt(col);
                } catch (Exception e) {
                    currentChar = ' ';
                }
                matrix[row][maxLength - 1 - col] = currentChar;
            }
        }
        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static char[][] fillMatrix90(List<String> allLines, int maxLength) {
        int rows = maxLength;
        int cols = allLines.size();
        char[][] matrix = new char[rows][cols];

        for (int col = 0; col < cols; col++) {
            String word = allLines.get(allLines.size() - 1 - col);
            for (int row = 0; row < rows; row++) {
                char currentChar;
                try {
                    currentChar = word.charAt(row);
                } catch (Exception e) {
                    currentChar = ' ';
                }
                matrix[row][col] = currentChar;
            }
        }

        return matrix;
    }

    private static char[][] fillMatrix0(List<String> allLines, int maxLength) {
        char[][] matrix = new char[allLines.size()][maxLength];

        for (int i = 0; i < allLines.size(); i++) {
            String word = allLines.get(i);
            for (int j = 0; j < maxLength; j++) {
                char currentChar;
                try {
                    currentChar = word.charAt(j);
                } catch (Exception e) {
                    currentChar = ' ';
                }
                matrix[i][j] = currentChar;
            }
        }

        return matrix;
    }


}
