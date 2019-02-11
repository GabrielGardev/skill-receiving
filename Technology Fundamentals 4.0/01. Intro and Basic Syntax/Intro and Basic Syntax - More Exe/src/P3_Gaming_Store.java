import java.util.Scanner;

public class P3_Gaming_Store {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double balance = Double.parseDouble(scanner.nextLine());
        double totalSpent = 0;

        while (true)
        {
            String command = scanner.nextLine();
            if (balance <= 0)
            {
                System.out.println("Out of money!");
                return;
            }

            if (command.equals("Game Time"))
            {
                System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpent, balance);
                break;
            }

            double price = 0;

            switch (command)
            {
                case "OutFall 4": price = 39.99; break;
                case "CS: OG": price = 15.99; break;
                case "Zplinter Zell": price = 19.99; break;
                case "Honored 2": price = 59.99; break;
                case "RoverWatch": price = 29.99; break;
                case "RoverWatch Origins Edition": price = 39.99; break;
                default:
                    System.out.println("Not Found");
                    continue;
            }

            if (balance - price < 0)
            {
                System.out.println("Too Expensive");

            }
            else
            {
                balance -= price;
                totalSpent += price;
                System.out.printf("Bought %s\n", command);
            }

        }
    }
}
