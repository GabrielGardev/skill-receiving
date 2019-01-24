import java.util.Scanner;

public class P2_Baking_Rush {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] events = scanner.nextLine().split("\\|");
        int energy = 100;
        int coins = 100;

        for (String event : events) {
            String[] currentEvent = event.split("-");
            String cmd = currentEvent[0];
            int number = Integer.parseInt(currentEvent[1]);

            switch (cmd) {
                case "rest":
                    if (energy == 100) {

                        number = 0;
                    } else if (energy + number > 100) {


                        number = 100 - energy;
                        energy = 100;

                    } else {

                        energy += number;
                    }

                    System.out.printf("You gained %d energy.%n", number);
                    System.out.printf("Current energy: %d.%n",energy);
                    break;
                case "order":
                    if (energy - 30 >= 0) {
                        System.out.printf("You earned %d coins.\n", number);
                        coins += number;
                        energy -= 30;
                    } else {
                        System.out.println("You had to rest!");
                        energy += 50;
                        continue;
                    }
                    break;
                default:
                    coins -= number;
                    if (coins <= 0) {
                        //bankrupt
                        System.out.printf("Closed! Cannot afford %s.\n", cmd);
                        return;
                    }
                    System.out.printf("You bought %s.\n", cmd);
                    break;
            }
        }
        System.out.println("Day completed!");
        System.out.println("Coins: " + coins);
        System.out.println("Energy: " + energy);
    }
}
