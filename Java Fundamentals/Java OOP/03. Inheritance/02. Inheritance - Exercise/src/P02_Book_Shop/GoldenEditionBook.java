package P02_Book_Shop;

public class GoldenEditionBook extends Book {

    public GoldenEditionBook(String title, String author, double price) {
        super(title, author, price);
    }

    @Override
    public double getPrice() {
        return super.getPrice() * 1.3;
    }
}
