package P09_Cat_Lady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Cat> cats = new ArrayList<>();

        while (true){
            String[] line = reader.readLine().split(" ");
            if (line[0].equals("End")){
                break;
            }
            String breed = line[0];
            String name = line[1];
            double input = Double.parseDouble(line[2]);

            Cat cat = null;

            if (breed.equals("Siamese")){
                cat = new Siamese(name, input);

            }else if (breed.equals("Cymric")){
                cat = new Cymric(name, input);
            }else {
                cat = new StreetExtraordinaire(name, input);
            }

            cats.add(cat);
        }

        String nameToPrint = reader.readLine();

        for (Cat cat : cats) {
            if (cat.getName().equals(nameToPrint)){
                System.out.println(cat.toString());
            }
        }
    }
}
