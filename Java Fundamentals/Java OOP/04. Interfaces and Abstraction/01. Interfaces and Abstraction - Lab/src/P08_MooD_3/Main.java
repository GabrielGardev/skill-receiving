package P08_MooD_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line = reader.readLine().split(" \\| ");

        String username = line[0];
        String type = line[1];
        int level = Integer.parseInt(line[3]);

        GameObject character = null;

        if (type.equals("Demon")) {

            Double specialPoints = Double.parseDouble(line[2]);
            character = new Demon(username, level, specialPoints);


            Integer pass = (character.getUsername().length() + 2) * 217;
            character.setHashedPassword(pass);

        } else if (type.equals("Archangel")) {
            Integer specialPoints = Integer.parseInt(line[2]);
            character = new Archangel(username, level, specialPoints);


            StringBuilder sb = new StringBuilder(username);

            sb.reverse().
                    insert(0, '"')
                    .append('"')
                    .append((character.getUsername().length() + 2) * 21);

            character.setHashedPassword(sb.toString());

        }
        System.out.println(character.toString());
    }
}
