import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class P01_Parking_Lot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        HashSet<String> carNumbers = new HashSet<>();
        while (true) {
            String [] input = reader.readLine().split(", ");
            String cmd = input[0];
            if (cmd.equals("END")){
                break;
            }
            String number = input[1];



            if (cmd.equals("IN")) {
                carNumbers.add(number);
            } else {
                carNumbers.remove(number);
            }

        }
        if (carNumbers.isEmpty()){
            System.out.println("Parking Lot is Empty");
            return;
        }

        for (String carNumber : carNumbers) {
            System.out.println(carNumber);
        }

    }
}
