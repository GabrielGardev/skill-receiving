package P03_Car_Shop_Extend;

public interface Rentable extends Car {
    Integer getMinRentDay();
    Double getPricePerDay();
}
