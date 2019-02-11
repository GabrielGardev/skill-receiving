package P10_Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] nameAndAddress = reader.readLine().split(" ");
        String name = nameAndAddress[0] + " " + nameAndAddress[1];
        String address = nameAndAddress[2];

        Tuple tuple = new Tuple(name, address);
        System.out.println(tuple.toString());

        String[] nameAndBeers = reader.readLine().split(" ");
        String name1 = nameAndBeers[0];
        int liters = Integer.parseInt(nameAndBeers[1]);

        Tuple tuple1 = new Tuple(name1, liters);
        System.out.println(tuple1.toString());

        String[] ageAndKilos = reader.readLine().split(" ");
        int age = Integer.parseInt(ageAndKilos[0]);
        double kilos = Double.parseDouble(ageAndKilos[1]);

        Tuple tuple2 = new Tuple(age, kilos);
        System.out.println(tuple2.toString());
    }
}
