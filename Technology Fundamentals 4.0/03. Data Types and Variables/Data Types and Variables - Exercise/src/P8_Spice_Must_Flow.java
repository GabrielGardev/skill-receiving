import java.util.Scanner;

public class P8_Spice_Must_Flow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long startingYield = Integer.parseInt(scanner.nextLine());
        long spice = 0;
        int days = 0;

        while (startingYield >= 100){
            days++;
            spice += (startingYield - 26);
            startingYield -= 10;
        }

        System.out.println(days);
        if (spice > 26){
            System.out.println(spice - 26);
        }else{
            System.out.println(spice);
        }
    }
}
