import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P3_House_Party {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> names = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];

            if (input.length == 4){
                if (names.contains(name)){
                    names.remove(name);
                }else {
                    System.out.println(name + " is not in the list!");
                }
            }else {
                if (!names.contains(name)){
                    names.add(name);
                }else {
                    System.out.println(name + " is already in the list!");
                }
            }
        }
        names.forEach(x -> System.out.println(x));
    }
}
