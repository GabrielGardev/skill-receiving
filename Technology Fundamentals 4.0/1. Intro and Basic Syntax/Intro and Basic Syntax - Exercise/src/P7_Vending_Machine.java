import java.util.Scanner;

public class P7_Vending_Machine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = 0;
        String input = scanner.nextLine();

        while (!input.equals("Start"))
        {
            double coin = Double.parseDouble(input);

            if (coin == 0.1)
            {
                money += 0.1;
            }
            else if (coin == 0.2)
            {
                money += 0.2;
            }
            else if (coin == 0.5)
            {
                money += 0.5;
            }
            else if (coin == 1)
            {
                money += 1;
            }
            else if (coin == 2)
            {
                money += 2;
            }
            else
            {
                System.out.printf("Cannot accept %.2f\n", coin);
            }

            input = scanner.nextLine();
        }

        while (true)
        {
            String command = scanner.nextLine();
            double price = 0;

            if (command.equals("End"))
            {
                System.out.printf("Change: %.2f", money);
                break;
            }

            switch (command)
            {
                case "Nuts":
                    price = 2;
                    break;
                case "Water":
                    price = 0.7;
                    break;
                case "Crisps":
                    price = 1.5;
                    break;
                case "Soda":
                    price = 0.8;
                    break;
                case "Coke":
                    price = 1;
                    break;
                default:
                    System.out.println("Invalid product");
                    continue;
            }

            if (price > money)
            {
                System.out.println("Sorry, not enough money");
            }
            else
            {
                System.out.printf("Purchased %s\n", command);
                money -= price;
            }
        }
    }
}
