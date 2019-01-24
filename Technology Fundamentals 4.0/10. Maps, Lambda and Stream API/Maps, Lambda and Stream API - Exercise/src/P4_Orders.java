import java.util.*;

public class P4_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Double> ordersPrices = new LinkedHashMap<>();
        Map<String, Integer> ordersQuantity = new LinkedHashMap<>();

        while (true){
            String[] line = scanner.nextLine().split(" ");
            if (line[0].equals("buy")){
                break;
            }

            String product = line[0];
            double price = Double.parseDouble(line[1]);
            int quantity = Integer.parseInt(line[2]);


            ordersPrices.put(product, price);

            if (ordersQuantity.containsKey(product) == false){
                ordersQuantity.put(product , 0);
            }
            ordersQuantity.put(product, ordersQuantity.get(product) + quantity);

        }
        for (var entry : ordersPrices.entrySet()) {
            System.out.printf("%s -> %.2f%n",entry.getKey(), ordersQuantity.get(entry.getKey()) * entry.getValue());
        }
    }
}
