package carconstructors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<carconstructors.Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("\\s+");
            String make;
            String model;
            int horsePower;

            carconstructors.Car car;

            if (line.length > 1){
                 make = line[0];
                 model = line[1];
                 horsePower = Integer.parseInt(line[2]);

                car = new carconstructors.Car(make, model, horsePower);
            }else {
                 make = line[0];
                 car = new carconstructors.Car(make);
            }

            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }
}
