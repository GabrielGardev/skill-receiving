import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class P4_Reverse_an_Array_of_Strings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        Collections.reverse(Arrays.asList(input));
        for (var letter:input){
            System.out.print(letter + " ");
        }
    }
}
