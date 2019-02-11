import java.util.Scanner;

public class P9_Padawan_Equipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double lightsaberPrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        int freeBelts = 0;
        if (students >= 6)
        {
            freeBelts = students / 6;
        }

        double costs = lightsaberPrice * (students + Math.ceil(students * 0.1)) +
                robePrice * students + beltPrice * (students - freeBelts);

        if (costs <= money)
        {
            System.out.printf("The money is enough - it would cost %.2flv.", costs);
        }
        else
        {
            System.out.printf("Ivan Cho will need %.2flv more.", costs - money);
        }
    }
}
