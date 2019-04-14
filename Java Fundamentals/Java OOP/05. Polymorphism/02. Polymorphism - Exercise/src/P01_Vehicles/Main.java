package P01_Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double[] carInfo = Arrays.stream(reader.readLine().split("\\s+"))
                .skip(1)
                .mapToDouble(Double::parseDouble)
                .toArray();

        Car car = new Car(carInfo[0], carInfo[1]);

        double[] truckInfo = Arrays.stream(reader.readLine().split("\\s+"))
                .skip(1)
                .mapToDouble(Double::parseDouble)
                .toArray();

        Truck truck = new Truck(truckInfo[0], truckInfo[1]);

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0){
            String[] line = reader.readLine().split("\\s+");

            switch (line[0]){
                case "Drive":
                    if (line[1].equals("Car")){
                        System.out.println(car.drive(Double.parseDouble(line[2])));
                    }else {
                        System.out.println(truck.drive(Double.parseDouble(line[2])));
                    }
                    break;
                case "Refuel":
                    if (line[1].equals("Car")){
                        car.refuel(Double.parseDouble(line[2]));
                    }else {
                        truck.refuel(Double.parseDouble(line[2]));
                    }
                    break;
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}
