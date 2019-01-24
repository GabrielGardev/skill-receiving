import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P6_Vehicle_Catalogue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> cars = new ArrayList<>();
        List<Vehicle> trucks = new ArrayList<>();

        while (true) {
            String[] line = scanner.nextLine().split(" ");
            if (line[0].equals("End")) {
                break;
            }

            String type = line[0];
            String model = line[1];
            String color = line[2];
            int hp = Integer.parseInt(line[3]);

            Vehicle vehicle = new Vehicle(type, model, color, hp);
            if (type.equals("car")) {
                cars.add(vehicle);
            } else {
                trucks.add(vehicle);
            }
        }

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("Close the Catalogue")) {
                break;
            }

            for (Vehicle car : cars) {
                if (car.getModel().equals(line)) {
                    System.out.println(car.toString());
                }
            }
            for (Vehicle truck : trucks) {
                if (truck.getModel().equals(line)) {
                    System.out.println(truck.toString());
                }
            }
        }
        double carsAverage = 0;
        double trucksAverage = 0;

        if (!cars.isEmpty()) {
            double sumCars = 0;
            for (Vehicle car : cars) {
                sumCars += car.getHorsepower();
            }
            carsAverage = sumCars / cars.size();
        }
        System.out.println(String.format("Cars have average horsepower of: %.2f.", carsAverage));

        if (!trucks.isEmpty()) {
            double sumTrucks = 0;
            for (Vehicle truck : trucks) {
                sumTrucks += truck.getHorsepower();
            }
            trucksAverage = sumTrucks / trucks.size();
        }
        System.out.println(String.format("Trucks have average horsepower of: %.2f.", trucksAverage));

    }

    static class Vehicle {
        private String type;
        private String model;
        private String color;
        private int horsepower;

        public Vehicle(String type, String model, String color, int horsepower) {
            this.setType(type);
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public int getHorsepower() {
            return horsepower;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            type = type.replace(type.charAt(0), Character.toUpperCase(type.charAt(0)));
            this.type = type;
        }

        @Override
        public String toString() {
            return String.format("Type: %s\nModel: %s\nColor: %s\nHorsepower: %s", getType(), getModel(), getColor(), getHorsepower());
        }
    }
}
