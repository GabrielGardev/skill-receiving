package P04_Shopping_Spree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(";");

        Map<String, Person> peoples = new LinkedHashMap<>();

        for (String person : input) {
            String name = person.split("=")[0];
            double money = Double.parseDouble(person.split("=")[1]);

            Person person1 = new Person(name, money);
            peoples.putIfAbsent(name, person1);
        }

        String[] inputProducts = reader.readLine().split(";");
        Map<String ,Product> products = new LinkedHashMap<>();

        for (String inputProduct : inputProducts) {
            String name = inputProduct.split("=")[0];
            double cost = Double.parseDouble(inputProduct.split("=")[1]);

            Product product = new Product(name, cost);
            products.putIfAbsent(name, product);
        }

        while (true){
            String line = reader.readLine();
            if("END".equals(line)){
                break;
            }
            String name = line.split(" ")[0];
            String product = line.split(" ")[1];

            if (peoples.containsKey(name) && products.containsKey(product)){
                Person currentPerson = peoples.get(name);
                Product currentProduct = products.get(product);
                if (currentPerson.getMoney() >= currentProduct.getCost()){
                    System.out.println(name + " bought " + product);
                    currentPerson.buyProduct(currentProduct);
                }else {
                    System.out.println(name + " can't afford " + product);
                }
            }
        }
        peoples.forEach((key, value) -> System.out.println(value.toString()));
    }
}
