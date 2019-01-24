import java.util.Scanner;

public class P7_NxN_Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(GetNxNMatrix(n));
    }

    private static String GetNxNMatrix(int n) {
        String result = "";

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += n + " ";
            }
            result += "\r\n";
        }
        return result;
    }
}
