import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P7_Cinema {
    public static List<String> friends;
    public static String[] seats;
    public static String[] combinations;
    public static boolean[] takenPlaces;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        friends = Arrays.stream(reader.readLine().split(", "))
                .collect(Collectors.toList());
        seats = new String[friends.size()];

        String line = reader.readLine();

        while (!line.equals("generate")) {
            String[] nameAndSeat = line.split(" - ");
            String person = nameAndSeat[0];
            int seat = Integer.parseInt(nameAndSeat[1]) - 1;

            putPerson(person, seat);
            friends.remove(person);

            line = reader.readLine();
        }
        combinations = new String[friends.size()];
        takenPlaces = new boolean[friends.size()];

        permute(0);
    }


    private static void putPerson(String person, int seat) {
        seats[seat] = person;
    }

    private static void permute(int index) {
        if (index >= combinations.length) {
            print();
        } else {
            for (int i = 0; i < friends.size(); i++) {
                if (!takenPlaces[i]) {
                    takenPlaces[i] = true;
                    combinations[index] = friends.get(i);
                    permute(index + 1);
                    takenPlaces[i] = false;
                }
            }
        }
    }

    private static void print() {
        List<String> result = new ArrayList<>();
        int index = 0;
        for (String seat : seats) {
            if (seat != null) {
                result.add(seat);
            } else {
                result.add(combinations[index++]);
            }
        }
        System.out.println(String.join(" ", result));
    }
}
