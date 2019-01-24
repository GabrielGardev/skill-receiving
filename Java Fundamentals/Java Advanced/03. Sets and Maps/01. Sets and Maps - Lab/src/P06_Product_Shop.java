import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class P06_Product_Shop {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String , LinkedHashMap<String, Double>> shops = new TreeMap<>();

        while (true){
            String[] line = reader.readLine().split(", ");
            if ("Revision".equals(line[0])){
                break;
            }
            String shop = line[0];
            String product = line[1];
            double price = Double.parseDouble(line[2]);

            shops.putIfAbsent(shop, new LinkedHashMap<>());
            shops.get(shop).put(product, price);
        }
        shops.forEach((key, value) -> {
            System.out.println(String.format("%s->",key));
            value.forEach((key1, value1) -> {
                System.out.println(String.format("Product: %s, Price: %.1f",key1, value1));
            });
        });
    }
}
