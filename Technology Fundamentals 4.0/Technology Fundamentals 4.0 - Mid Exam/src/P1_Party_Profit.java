import java.util.Scanner;

public class P1_Party_Profit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int partySize = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        int coins = 0;


        for (int day = 1; day <= days; day++) {

            coins += 50;
            if (day % 10 == 0) {
                partySize -= 2;
            }
            if (day % 15 == 0) {
                partySize += 5;
            }

            // for drinking water
            if (day % 3 == 0) {
                coins -= (3 * partySize);
            }
            //slay monster
            if (day % 5 == 0) {
                coins += 20 * partySize;
            }
            if (day % 5 == 0 && day % 3 == 0){
                coins -= 2 * partySize;
            }
            coins -= (2 * partySize);
        }

        int eachComp = coins / partySize;

        System.out.printf("%d companions received %d coins each.", partySize, eachComp);
    }
}

