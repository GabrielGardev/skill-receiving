import java.util.Scanner;

public class P5_Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cycles = Integer.parseInt(scanner.nextLine());
        String result = "";

        for (int i = 0; i < cycles; i++)
        {
            String temp = scanner.nextLine();
            int combination = Integer.parseInt(temp);
            int numberOfDigits = temp.length();
            int mainDig = combination % 10;
            int offset = (mainDig - 2) * 3;

            if (mainDig == 7 || mainDig == 9)
            {
                offset += 1;
            }

            int letterIndex = (offset + numberOfDigits - 1);

            char mainLetter = (char)(letterIndex + 97);

            result += mainLetter;
        }
        System.out.println(result);
    }
}
