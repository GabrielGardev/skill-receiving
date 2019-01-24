import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02_Matrix_of_Palindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String [] input = reader.readLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);


        for (int row = 0; row < rows; row++) {
            char firstAndLastSymbol = (char)(97 + row);

            for (int col = 0; col < cols; col++) {
                char middleSymbol = (char)(firstAndLastSymbol + col);

                System.out.print("" + firstAndLastSymbol + middleSymbol + firstAndLastSymbol + " ");
            }
            System.out.println();
        }

    }
}
