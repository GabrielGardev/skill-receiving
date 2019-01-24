import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class P9_Palindrome_Integers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            String command = scanner.nextLine();

            if (command.equals("END")){
                break;
            }


            PrintIsItPalidrome(command);
        }
    }

    private static void PrintIsItPalidrome(String number) {
        String temp = "";

        for (int i = number.length() - 1; i >= 0; i--) {
            temp += number.charAt(i);
        }
        if (number.equals(temp)){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}
