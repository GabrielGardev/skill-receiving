import java.util.Scanner;

public class P3_Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ppl = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());

        int courses = ppl / capacity;


        if (ppl % capacity != 0)
        {
            courses++;
        }


        System.out.println(courses);
    }
}
