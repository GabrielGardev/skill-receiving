import java.io.Console;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class P5_Month_Printer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int month = Integer.parseInt(scanner.nextLine());
        if (month > 12 || month < 1)
        {
            System.out.println("Error!");
            return;
        }

        String [] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September"
        , "October", "November", "December"};

        System.out.printf("%s", months[month - 1]);
    }
}
