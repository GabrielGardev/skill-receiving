package implementations;

public class TheMatrix {
    private char[][] matrix;
    private char fillChar;
    private char toBeReplaced;
    private int startRow;
    private int startCol;

    public TheMatrix(char[][] matrix, char fillChar, int startRow, int startCol) {
        this.matrix = matrix;
        this.fillChar = fillChar;
        this.startRow = startRow;
        this.startCol = startCol;
        this.toBeReplaced = this.matrix[this.startRow][this.startCol];
    }

    public void solve() {
        replaceMatrix(startRow, startCol);
    }

    public String toOutputString() {
        StringBuilder result = new StringBuilder();

        for (char[] matrix1 : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                result.append(matrix1[j]);
            }
            result.append(System.lineSeparator());
        }

        return result.toString().trim();
    }

    private  void replaceMatrix(int row, int col) {
        if (outOfBounds(row, col) || matrix[row][col] != toBeReplaced) {
            return;
        }

        matrix[row][col] = fillChar;

        replaceMatrix(row + 1, col);
        replaceMatrix(row - 1, col);
        replaceMatrix(row, col + 1);
        replaceMatrix(row, col - 1);
    }

    private boolean outOfBounds(int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length;
    }
}
