package P04_Shopping_Spree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.isEmpty() || name.contains(" ")) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public double getMoney() {
        return this.money;
    }

    public void buyProduct(Product product) {
        this.setMoney(this.money - product.getCost());
        this.products.add(product);
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        if (this.products.isEmpty()) {
            return String.format("%s - Nothing bought", this.name);
        } else {
            return this.name + " - " +
                    this.products.stream()
                            .map(Product::getName)
                            .collect(Collectors.joining(", "));
        }
    }
}
