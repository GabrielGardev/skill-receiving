package P02_Vehicles_Extension;

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

        Car car = new Car(carInfo[0], carInfo[1], carInfo[2]);

        double[] truckInfo = Arrays.stream(reader.readLine().split("\\s+"))
                .skip(1)
                .mapToDouble(Double::parseDouble)
                .toArray();

        Truck truck = new Truck(truckInfo[0], truckInfo[1], truckInfo[2]);

        double[] busInfo = Arrays.stream(reader.readLine().split("\\s+"))
                .skip(1)
                .mapToDouble(Double::parseDouble)
                .toArray();

        Bus bus = new Bus(busInfo[0], busInfo[1], busInfo[2]);

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0){
            String[] line = reader.readLine().split("\\s+");

            switch (line[0]){
                case "Drive":
                    double distance = Double.parseDouble(line[2]);

                    if (line[1].equals("Car")){
                        System.out.println(car.drive(distance));
                    }else if (line[1].equals("Truck")){
                        System.out.println(truck.drive(distance));
                    }else {
                        System.out.println(bus.driveWithPpl(distance));
                    }
                    break;

                case "Refuel":
                    double fuel = Double.parseDouble(line[2]);
                    if (line[1].equals("Car")){
                        if (car.refuel(fuel) != null) {
                            System.out.println(car.refuel(fuel));
                        }
                    }else if (line[1].equals("Truck")){
                        if (truck.refuel(fuel) != null) {
                            System.out.println(truck.refuel(fuel));
                        }
                    }else {
                        if (bus.refuel(fuel) != null) {
                            System.out.println(bus.refuel(fuel));
                        }
                    }
                    break;

                case "DriveEmpty":
                    System.out.println(bus.drive(Double.parseDouble(line[2])));
                    break;
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }
}
