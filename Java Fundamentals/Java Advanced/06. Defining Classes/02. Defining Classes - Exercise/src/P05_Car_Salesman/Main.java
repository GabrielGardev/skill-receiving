package P05_Car_Salesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        while (n-- > 0) {
            String [] line = scanner.nextLine().split("\\s+");
            String model = line[0];
            int power = Integer.parseInt(line[1]);

            Engine engine = new Engine(model, power);
            if (line.length > 2){
                try {
                    int displacement = Integer.parseInt(line[2]);
                    String temp = displacement + "";
                    engine.setDisplacement(temp);
                    engine.setEfficiency("n/a");
                }catch (Exception e){
                    String efficiency = line[2];
                    engine.setEfficiency(efficiency);
                    engine.setDisplacement("n/a");
                }

                if (line.length == 4){
                    String efficiency = line[3];
                    engine.setEfficiency(efficiency);
                }
            }else {
                engine.setEfficiency("n/a");
                engine.setDisplacement("n/a");
            }
            engines.add(engine);
        }
        int m = Integer.parseInt(scanner.nextLine());

        while (m-- > 0) {
            String [] line = scanner.nextLine().split("\\s+");
            String model = line[0];
            String engine = line[1];

            Car car = new Car(model);
            for (Engine engine1 : engines) {
                if (engine1.getEngineModel().equals(engine)) {
                    car.setEngine(engine1);
                    break;
                }
            }

            if (line.length > 2){
                try {
                    int weigh = Integer.parseInt(line[2]);
                    String temp = weigh + "";
                    car.setWeight(temp);
                    car.setColor("n/a");
                }catch (Exception e){
                    String color = line[2];
                    car.setColor(color);
                    car.setWeight("n/a");
                }
                if (line.length == 4){
                    String color = line[3];
                    car.setColor(color);
                }
            }else {
                car.setColor("n/a");
                car.setWeight("n/a");
            }
            cars.add(car);
        }
        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }
}
