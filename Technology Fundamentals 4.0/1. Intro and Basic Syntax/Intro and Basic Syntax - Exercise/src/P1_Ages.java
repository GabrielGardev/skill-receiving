import java.util.Scanner;

public class P1_Ages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        String person = "";

        if (0 <= age && age <= 2)
        {
            person = "baby";
        }
        else if(age <= 13)
        {
            person = "child";
        }
        else if (age <= 19)
        {
            person = "teenager";
        }
        else if (age <= 65)
        {
            person = "adult";
        }
        else if (age >= 66)
        {
            person = "elder";
        }

        System.out.println(person);
    }
}
