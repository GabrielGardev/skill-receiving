import java.util.*;

public class NewCashierDoesNotKnowAboutSpaceOrShift {
    public static void main(String[] args) {
        System.out.println(getOrder("milkshakepizzachickenfriescokeburgerpizzasandwichmilkshakepizza"));
    }

    private final static List<String> MENU = Arrays.asList(
            "Burger",
            "Fries",
            "Chicken",
            "Pizza",
            "Sandwich",
            "Onionrings",
            "Milkshake" ,
            "Coke"
    );

    public static String getOrder(String input) {


        StringBuilder order = new StringBuilder();
        for (String dish : MENU) {
            int dishCounter = input.split(dish.toLowerCase(), -1).length - 1;
            order.append(String.join(" ", Collections.nCopies(dishCounter, dish))).append(" ");
        }
        return order.toString().trim().replaceAll("\\s+", " ");
    }
}
