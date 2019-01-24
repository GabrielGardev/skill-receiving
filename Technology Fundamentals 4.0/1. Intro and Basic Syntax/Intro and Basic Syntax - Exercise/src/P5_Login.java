import java.util.Scanner;

public class P5_Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userName = scanner.nextLine();
        String password = new StringBuilder(userName).reverse().toString();

        String inputPassword = scanner.nextLine();
        int counter = 1;

        while (!inputPassword.equals(password)) {
            if (counter == 4) {
                System.out.printf("User %s blocked!", userName);
                return;
            }
            System.out.println("Incorrect password. Try again.");
            counter++;
            inputPassword = scanner.nextLine();
        }
        System.out.printf("User %s logged in.", userName);
    }


}
