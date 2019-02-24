package P03_SoftUni_Parking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parking {
    private Map<String, Car> cars;
    private int capacity;
    private int count;

    public Parking(int capacity) {
        this.cars = new HashMap<>();
        this.capacity = capacity;
        this.count = 0;
    }

    public String addCar(Car car){
        if (this.cars.containsKey(car.getRegistrationNumber())){
            return "Car with that registration number, already exists!";
        }else if (this.count >= this.capacity){
            return "Parking is full!";
        }else {
            this.cars.put(car.getRegistrationNumber(), car);
            count++;
            return String.format("Successfully added new car %s %s", car.getMake(), car.getRegistrationNumber());
        }
    }

    public String removeCar(String registrationNumber){
        if (!this.cars.containsKey(registrationNumber)){
            return "Car with that registration number, doesn't exists!";
        }else{
            this.cars.remove(registrationNumber);
            count--;
            return String.format("Successfully removed %s", registrationNumber);
        }
    }

    public Car getCar(String registrationNumber){
        return this.cars.get(registrationNumber);
    }

    public void removeSetOfRegistrationNumber(List<String> registrationNumbers){
        for (String registrationNumber : registrationNumbers) {
            this.removeCar(registrationNumber);
        }
    }

    public int getCount() {
        return count;
    }
}
