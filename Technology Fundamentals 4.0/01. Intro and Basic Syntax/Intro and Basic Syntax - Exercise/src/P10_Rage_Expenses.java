import java.util.Scanner;

public class P10_Rage_Expenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGames = Integer.parseInt(scanner.nextLine());
        double headset = Double.parseDouble(scanner.nextLine());
        double mouse = Double.parseDouble(scanner.nextLine());
        double keyboard = Double.parseDouble(scanner.nextLine());
        double display = Double.parseDouble(scanner.nextLine());

        int trashedHeadset = 0;
        int trashedMouses = 0;
        int trashedKeyboards = 0;
        int trashedDisplays = 0;

        int secondGames = 0;
        int thirdGames = 0;
        int trashedKeyCounter = 0;

        for (int i = 0; i < lostGames; i++)
        {
            secondGames++;
            thirdGames++;

            if (secondGames == 2)
            {
                trashedHeadset++;
                secondGames = 0;
            }
            if (thirdGames == 3)
            {
                trashedMouses++;
                thirdGames = 0;
            }
            if (secondGames == 0 && thirdGames == 0)
            {
                trashedKeyboards++;
                trashedKeyCounter++;
            }
            if (trashedKeyCounter == 2)
            {
                trashedDisplays++;
                trashedKeyCounter = 0;
            }
        }

        double price = trashedHeadset * headset + trashedMouses * mouse + trashedKeyboards * keyboard + trashedDisplays * display;

        System.out.printf("Rage expenses: %.2f lv.", price);
    }
}
