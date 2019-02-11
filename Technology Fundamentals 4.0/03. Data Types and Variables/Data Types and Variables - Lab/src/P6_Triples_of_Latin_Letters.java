import java.util.Scanner;

public class P6_Triples_of_Latin_Letters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (char i = 'a'; i < 'a' + n; i++)
        {
            for (char k = 'a'; k < 'a' + n; k++)
            {
                for (char j = 'a'; j < 'a' + n; j++)
                {
                    System.out.println(String.format("%c%c%c", i, k, j));
                }
            }
        }
    }
}
