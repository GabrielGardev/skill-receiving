import java.util.Scanner;

public class P7_Winning_Ticket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] tickets = scanner.nextLine().split(",\\s+");

        for (int i = 0; i < tickets.length; i++) {
            String currentTicket = tickets[i].trim();

            if (currentTicket.length() == 20){
                int maxCount = 1;
                int counter = 1;
                char specialChar = '\0';
                for (int j = 0; j < 9; j++) {
                    if (currentTicket.charAt(j) == '@' || currentTicket.charAt(j) == '$' ||
                    currentTicket.charAt(j) == '#' || currentTicket.charAt(j) == '^'){
                        if (currentTicket.charAt(j) == currentTicket.charAt(j + 1)){
                            counter++;
                        }else {
                            counter = 1;
                        }

                        if (counter > maxCount){
                            maxCount = counter;
                            specialChar = currentTicket.charAt(j);
                        }
                    }
                }

                if (maxCount < 6){
                    System.out.println(String.format("ticket \"%s\" - no match", currentTicket));
                    continue;
                }
                int counter2 = 0;
                int maxCounter2 = 0;
                for (int j = 10; j <= 19; j++) {
                    if (currentTicket.charAt(j) == specialChar){
                        counter2++;
                    }else {
                        counter2 = 0;
                    }

                    if (counter2 > maxCounter2){
                        maxCounter2 = counter2;
                    }
                }
                if (maxCount == 10 && maxCounter2 == 10){
                    System.out.println(String.format("ticket \"%s\" - %d%c Jackpot!", currentTicket, maxCount, specialChar));
                    continue;
                }

                if (maxCounter2 >= 6){
                    System.out.println(String.format("ticket \"%s\" - %d%c", currentTicket, Math.min(maxCount, maxCounter2), specialChar));
                }else {
                    System.out.println(String.format("ticket \"%s\" - no match", currentTicket));
                }
            }else {
                System.out.println("invalid ticket");
            }
        }
    }
}
