import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P01_Compare_Matrices {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int [][] firstMatrix = new int[nums[0]][nums[1]];



            for (int row = 0; row < firstMatrix.length; row++) {
                int[] numsToInsert = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int col = 0; col < firstMatrix[0].length; col++) {
                    firstMatrix[row][col] = numsToInsert[col];
                }
            }


        int[] nums2 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int [][] secondMatrix = new int[nums2[0]][nums2[1]];


            for (int row = 0; row < secondMatrix.length; row++) {
                int[] numsToInsert = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int col = 0; col < secondMatrix[0].length; col++) {
                    secondMatrix[row][col] = numsToInsert[col];
                }
            }


        if (firstMatrix.length != secondMatrix.length){
            System.out.println("not equal");
            return;
        }else {
            for (int row = 0; row < firstMatrix.length; row++) {
                if (firstMatrix[row].length != secondMatrix[row].length){
                    System.out.println("not equal");
                    return;
                }
                for (int col = 0; col < firstMatrix[0].length; col++) {
                    if (firstMatrix[row][col] != secondMatrix[row][col]){
                        System.out.println("not equal");
                        return;
                    }
                }
            }
        }
        System.out.println("equal");
    }
}
