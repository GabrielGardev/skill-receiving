package P2_Raw_Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            String model = line[0];
            int engineSpeed = Integer.parseInt(line[1]);
            int enginePower = Integer.parseInt(line[2]);
            int cargoWight = Integer.parseInt(line[3]);
            String cargoType = line[4];
            double tirePressure1 = Double.parseDouble(line[5]);
            int tireAge1 = Integer.parseInt(line[6]);
            double tirePressure2 = Double.parseDouble(line[7]);
            int tireAge2 = Integer.parseInt(line[8]);
            double tirePressure3 = Double.parseDouble(line[9]);
            int tireAge3 = Integer.parseInt(line[10]);
            double tirePressure4 = Double.parseDouble(line[11]);
            int tireAge4 = Integer.parseInt(line[12]);

            Tire tire = new Tire(tirePressure1, tireAge1);
            Tire tire2 = new Tire(tirePressure2, tireAge2);
            Tire tire3 = new Tire(tirePressure3, tireAge3);
            Tire tire4 = new Tire(tirePressure4, tireAge4);

            List<Tire> tires = new ArrayList<>();
            tires.add(tire);
            tires.add(tire2);
            tires.add(tire3);
            tires.add(tire4);


            Car car = new Car(model,
                    new Engine(engineSpeed, enginePower),
                    new Cargo(cargoWight, cargoType), tires);

            cars.add(car);
        }
        String line = scanner.nextLine();

        switch (line){
            case "fragile":
                for (Car car : cars) {
                    if (car.getCargo().getCargoType().equals(line)){
                        for (var car1 : car.getTires()) {
                            if (car1.getTirePressure() < 1){
                                System.out.println(car.getModel());
                                break;
                            }
                        }
                    }
                }
                break;
            case "flamable":
                for (Car car : cars) {
                    if (car.getCargo().getCargoType().equals(line)){
                        if (car.getEngine().getEnginePower() > 250){
                            System.out.println(car.getModel());
                        }
                    }
                }
                break;
        }
    }
}
