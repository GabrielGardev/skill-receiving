import java.util.Scanner;

public class P1_Days_of_week {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        int input = Integer.parseInt(scanner.nextLine());

        if (input < 1 || input > 7){
            System.out.println("Invalid day!");
            return;
        }
        System.out.println(daysOfWeek[input - 1]);
    }
}
