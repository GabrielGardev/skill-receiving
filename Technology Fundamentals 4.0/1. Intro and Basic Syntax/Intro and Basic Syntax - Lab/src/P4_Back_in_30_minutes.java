import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class P4_Back_in_30_minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine()) + 30;

        if (minutes > 59){
            minutes -= 60;
            hours++;
        }
        if (hours > 23){
            hours -= 24;
        }

        System.out.printf("%d:%02d", hours, minutes);
    }
}
