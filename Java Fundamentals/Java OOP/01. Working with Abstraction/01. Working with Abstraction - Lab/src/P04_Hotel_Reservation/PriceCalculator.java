package P04_Hotel_Reservation;

public class PriceCalculator {
    public static double calculate(ReservationDetails details){
        double price = details.getPricePerDay() * details.getNumberOfDays();

        price *= details.getSeason().getResult();

        price *= 1 - details.getDiscount().getDiscount();
        return price;
    }
}
