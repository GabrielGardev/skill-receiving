import java.util.Scanner;

public class P1_Baking_Masterclass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceFlour = Double.parseDouble(scanner.nextLine());
        double priceEgg = Double.parseDouble(scanner.nextLine());
        double priceApron = Double.parseDouble(scanner.nextLine());

        double countOfAprons = students + Math.ceil(students * 0.2);
        double eggs = students * 10;

        int freeFlour = 0;
        if (students >= 5){
            freeFlour = students / 5;
        }

        double costs = (priceFlour * (students - freeFlour)) + (eggs * priceEgg) + (countOfAprons * priceApron);

        if (costs <= budget){
            System.out.printf("Items purchased for %.2f$.", costs);
        }else {
            System.out.printf("%.2f$ more needed.", costs - budget);
        }

    }
}
