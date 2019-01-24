import java.util.Scanner;

public class P2_Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String removal = scanner.nextLine();
        String removingFrom = scanner.nextLine();
        while (removingFrom.contains(removal)){
            removingFrom = removingFrom.replace(removal, "");
        }
        System.out.println(removingFrom);

    }
}
