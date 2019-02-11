import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P1_Encrypt_Sort_and_Print_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] encrypts = new int[n];

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            int sum = 0;

            for (int j = 0; j < input.length(); j++) {
                char currentChar = input.charAt(j);
                switch (currentChar){
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        sum += currentChar * input.length();
                        break;
                        default:
                            sum += currentChar / input.length();
                            break;
                }
            }
            encrypts[i] = sum;
        }
        Arrays.sort(encrypts);
        for (int encrypt : encrypts) {
            System.out.println(encrypt);
        }
    }
}
