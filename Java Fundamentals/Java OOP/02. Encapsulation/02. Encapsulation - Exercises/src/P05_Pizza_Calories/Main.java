package P05_Pizza_Calories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] pizzaRead = reader.readLine().split("\\s+");
        Pizza pizza = new Pizza();
        int ingredients = 0;

        if (pizzaRead[0].equals("Pizza")){
            ingredients = Integer.parseInt(pizzaRead[2]);
            pizza = new Pizza(pizzaRead[1], ingredients);
        }

        String[] doughRead = reader.readLine().split("\\s+");
        Dough dough = new Dough();

        if (doughRead[0].equals("Dough")){
            dough = new Dough(doughRead[1], doughRead[2], Double.parseDouble(doughRead[3]));
        }

        pizza.setDough(dough);

        for (int i = 0; i < ingredients; i++) {
            String[] toppingLine = reader.readLine().split("\\s+");

            if (toppingLine[0].equals("Topping")){
                Topping topping = new Topping(toppingLine[1], Double.parseDouble(toppingLine[2]));
                pizza.addTopping(topping);
            }
        }

        System.out.println(pizza.toString());
    }
}
