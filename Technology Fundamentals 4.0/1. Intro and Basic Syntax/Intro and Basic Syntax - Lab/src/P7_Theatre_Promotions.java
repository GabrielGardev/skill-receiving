import java.util.Scanner;

public class P7_Theatre_Promotions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String  typeOfDay = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        int price = 0;

        if (age < 0 || age > 122)
        {
            System.out.println("Error!");
            return;
        }

        if (typeOfDay.equals("Weekend"))
        {
            if (0 <= age && age <= 18)
            {
                price = 15;
            }
            else if (age <= 64)
            {
                price = 20;
            }
            else if (age <= 122)
            {
                price = 15;
            }
        }
        else if (typeOfDay.equals("Weekday"))
        {
            if (0 <= age && age <= 18)
            {
                price = 12;
            }
            else if (age <= 64)
            {
                price = 18;
            }
            else if (age <= 122)
            {
                price = 12;
            }
        }
        else if (typeOfDay.equals("Holiday"))
        {
            if (0 <= age && age <= 18)
            {
                price = 5;
            }
            else if (age <= 64)
            {
                price = 12;
            }
            else if (age <= 122)
            {
                price = 10;
            }
        }
        System.out.printf("%d$", price);
    }
}
