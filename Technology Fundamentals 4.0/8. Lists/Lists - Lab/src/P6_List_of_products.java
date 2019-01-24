import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P6_List_of_products {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> products = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            products.add(scanner.nextLine());
        }

        Collections.sort(products);

        for (int i = 0; i < n; i++) {
            System.out.println((1 + i) + "." + products.get(i));
        }
    }
}
