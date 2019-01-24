import java.util.Scanner;

public class P6_Strong_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int currentNum = Integer.parseInt(scanner.nextLine());
        int num = currentNum;
        int sum = 0;

        while (currentNum > 0)
        {
            int number = currentNum % 10;
            sum += Factorial(number);
            currentNum = currentNum / 10;
        }

        if (num == sum)
        {
            System.out.println("yes");
        }
        else
        {
            System.out.println("no");
        }
    }
    public static int Factorial(int facno)
    {
        int temno = 1;

        for (int i = 1; i <= facno; i++)
        {
            temno = temno * i;
        }

        return temno;

    }
}
