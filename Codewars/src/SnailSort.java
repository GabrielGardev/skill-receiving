import java.util.Arrays;

public class SnailSort {
    public static void main(String[] args) {
        int[][] array
                = {{1, 2, 3, 9},
                {4, 5, 6, 4},
                {7, 8, 9, 1},
                {1, 2, 3, 4}};
        int[] result = snail(array);
        String s = Arrays.toString(result);
        System.out.println(s);
    }

    public static int[] snail(int[][] array) {
        int size = 0;
        if (array.length <= 0){
           return new int[size];
        }

        if (array.length == 1){
            return array[0];
        }

        size = array.length * array.length;

        int[] result = new int[size];
        int index = 0;

        int rowStart = 0;
        int rowEnd = array.length - 1;
        int cowStart = 0;
        int colEnd = array.length - 1;

        for (int i = 0; i < array.length / 2; i++) {
            for (int row = rowStart; row <= rowEnd; row++) {
                result[index++] = array[cowStart][row];
            }
            cowStart++;

            for (int col = cowStart; col <= colEnd; col++) {
                result[index++] = array[col][rowEnd];
            }
            colEnd--;

            for (int row = colEnd; row >= rowStart; row--) {
                result[index++] = array[rowEnd][row];
            }
            rowEnd--;

            for (int col = colEnd; col >= cowStart; col--) {
                result[index++] = array[col][rowStart];
            }
            rowStart++;
        }

        if (array.length % 2 != 0){
            result[index] = array[rowStart][cowStart];
        }


        return result;
    }
}
