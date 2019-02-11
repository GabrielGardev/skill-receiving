package P11_Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] nameAndAddress = reader.readLine().split(" ");
        String name = nameAndAddress[0] + " " + nameAndAddress[1];
        String address = nameAndAddress[2];
        String town = nameAndAddress[3];

        Tuple tuple = new Tuple(name, address, town);
        System.out.println(tuple.toString());

        String[] nameAndBeers = reader.readLine().split(" ");
        String name1 = nameAndBeers[0];
        int liters = Integer.parseInt(nameAndBeers[1]);

        Tuple tuple1 = new Tuple(name1, liters, Tuple.drunkOrNot(nameAndBeers[2]));
        System.out.println(tuple1.toString());

        String[] bankInfo = reader.readLine().split(" ");
        String holderName = bankInfo[0];
        double bankBalance = Double.parseDouble(bankInfo[1]);
        String bankName = bankInfo[2];

        Tuple tuple2 = new Tuple(holderName, bankBalance, bankName);
        System.out.println(tuple2.toString());
    }
}
