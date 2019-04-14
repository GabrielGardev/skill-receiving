
import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {
    private List<Product> stock;

    public Instock() {
        this.stock = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.stock.size();
    }

    @Override
    public boolean contains(Product product) {
        return this.stock.contains(product);
    }

    @Override
    public void add(Product product) {
        this.stock.add(product);
    }

    @Override
    public void changeQuantity(String name, int quantity) {
        int index = this.stock.indexOf(new Product(name, 1, 1));
        if (index < 0){
            throw new IllegalArgumentException();
        }
        int newQuantity = this.stock.get(index).getQuantity() + quantity;

        this.stock.get(index).setQuantity(newQuantity);
    }

    @Override
    public Product find(int index) {
        return this.stock.get(index - 1);
    }

    @Override
    public Product findByLabel(String label) {
        Product product = this.stock.stream()
                .filter(x -> x.getLabel().equals(label))
                .findFirst()
                .orElse(null);

        if (product == null){
            throw new IllegalArgumentException();
        }
        return product;
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (count < 1 || count > this.getCount()){
            return new ArrayList<>();
        }

        return this.stock
                .stream()
                .sorted(Product::compareTo)
                .limit(count)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        return this.stock
                .stream()
                .filter(x -> x.getPrice() > lo && x.getPrice() <= hi)
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
       return this.findAllInRange(price - 0.0000001, price);
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if (this.getCount() < count){
            throw new IllegalArgumentException();
        }
        List<Product> range = (List<Product>) this.findAllInRange(0, Double.MAX_VALUE);
        Collections.reverse(range);
        return range.stream().limit(count).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return this.stock
                .stream()
                .filter(p -> p.getQuantity() == quantity)
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
        return this.stock.iterator();
    }
}
