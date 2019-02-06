package P03_Speed_Racing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Car> cars = new LinkedHashMap<>();

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0){
            String[] line = reader.readLine().split("\\s+");
            String model = line[0];
            double fuelAmount = Double.parseDouble(line[1]);
            double fuelCostForOneKm = Double.parseDouble(line[2]);

            Car car = new Car(model, fuelAmount, fuelCostForOneKm);

            cars.put(model, car);
        }

        while (true){
            String[] line = reader.readLine().split("\\s+");
            if (line[0].equals("End")){
                break;
            }
            String model = line[1];
            double amountOfKm = Double.parseDouble(line[2]);

            if (!cars.get(model).drive(amountOfKm)){
                System.out.println("Insufficient fuel for the drive");
            }
        }
        for (var entry : cars.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }
}
