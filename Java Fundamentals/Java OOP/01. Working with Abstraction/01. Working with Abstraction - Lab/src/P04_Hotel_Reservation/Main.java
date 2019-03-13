package P04_Hotel_Reservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line = reader.readLine().split("\\s+");

        double pricePerDay = Double.parseDouble(line[0]);
        int days = Integer.parseInt(line[1]);
        Season season = Season.valueOf(line[2]);
        Discount discountType = Discount.valueOf(line[3]);

        ReservationDetails details = new ReservationDetails(pricePerDay, days, season, discountType);

        System.out.println(String.format("%.2f",PriceCalculator.calculate(details)));
    }
}
