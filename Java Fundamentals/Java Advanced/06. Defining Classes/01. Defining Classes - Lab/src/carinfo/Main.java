package carinfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n =Integer.parseInt(reader.readLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("\\s+");
            String make = line[0];
            String model = line[1];
            int horsePower = Integer.parseInt(line[2]);

            Car car = new Car();
            car.setMake(make);
            car.setModel(model);
            car.setHorsePower(horsePower);

            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }
}
