import java.util.Scanner;

public class P5_Multiply_Big_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String bigNum = scanner.nextLine();
        int multi = Integer.parseInt(scanner.nextLine());
        if (multi == 0)
        {
            System.out.println("0");
            return;
        }

        StringBuilder sb = new StringBuilder();

        int num = 0;
        int reminder = 0;
        int sum = 0;
        for (int i = bigNum.length()- 1; i >= 0; i--) {
            sum = (bigNum.charAt(i) - 48) * multi + reminder;
            num = sum % 10;

            if (sum > 9)
            {
                reminder = sum / 10;
            }
            else
            {
                reminder = 0;
            }

            sb.append(num);

            if (i == 0 && reminder > 0)
            {
                sb.append(reminder);
            }
        }
        System.out.println(sb.reverse().toString());
    }
}
