package P04_Hotel_Reservation;

public enum Discount {
    None(0),
    SecondVisit(10),
    VIP(20);

    private int discount;

    Discount(int discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount / 100.0;
    }
}
