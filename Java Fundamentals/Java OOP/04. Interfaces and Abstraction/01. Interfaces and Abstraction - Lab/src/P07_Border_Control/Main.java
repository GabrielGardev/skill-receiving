package P07_Border_Control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Identifiable> citizens = new ArrayList<>();

        String input = reader.readLine();

        while (!"End".equals(input)) {
            String[] line = input.split("\\s+");

            if (line.length == 2){
                //robot
                Robot robot = new Robot(line[0], line[1]);
                citizens.add(robot);
            }else if(line.length == 3) {
                Citizen citizen = new Citizen(line[0], Integer.parseInt(line[1]), line[2]);
                citizens.add(citizen);
            }
            input = reader.readLine();
        }
        String fakeId = reader.readLine();

        for (Identifiable citizen : citizens) {
            if (citizen.getId().endsWith(fakeId)){
                System.out.println(citizen.getId());
            }
        }
    }
}
