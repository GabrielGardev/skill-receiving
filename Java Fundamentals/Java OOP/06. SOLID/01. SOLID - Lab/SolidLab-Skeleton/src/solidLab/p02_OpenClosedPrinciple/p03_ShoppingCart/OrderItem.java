package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart;

public class OrderItem extends Order{
    private String sku;

    private int Quantity;

    protected OrderItem(Cart cart) {
        super(cart);
    }

    public String getSku() {
        return this.sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getQuantity() {
        return this.Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
