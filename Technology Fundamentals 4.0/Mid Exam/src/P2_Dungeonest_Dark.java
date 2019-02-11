import java.util.Scanner;

public class P2_Dungeonest_Dark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hp = 100;
        int coins = 0;

        String[] rooms = scanner.nextLine().split("\\|");

        for (int i = 0; i < rooms.length; i++) {
            String[] line = rooms[i].split(" ");
            String cmd = line[0];
            int number = Integer.parseInt(line[1]);


            if (cmd.equals("potion")){
                if (hp == 100) {

                    number = 0;
                } else if (hp + number > 100) {

                    number = 100 - hp;
                    hp = 100;

                } else {
                    hp += number;
                }
                System.out.printf("You healed for %d hp.%n", number);
                System.out.printf("Current health: %d hp.%n", hp);
            }else if (cmd.equals("chest")){
                coins += number;
                System.out.printf("You found %d coins.%n", number);
            }else {
                hp -= number;
                //dead
                if (hp <= 0){
                    System.out.printf("You died! Killed by %s.%n", cmd);
                    System.out.printf("Best room: %d", i + 1);
                    return;
                }else {
                    System.out.printf("You slayed %s.%n",cmd);
                }
            }
        }
        System.out.println("You've made it!");
        System.out.printf("Coins: %d%n", coins);
        System.out.printf("Health: %d", hp);
    }
}
