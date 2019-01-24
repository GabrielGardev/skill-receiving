import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class P07_Cities_by_Continent_and_Country {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Map<String, LinkedHashMap<String, List<String>>> countryRecorder = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String [] line = reader.readLine().split(" ");
            String continent = line[0];
            String country = line[1];
            String city = line[2];

            if (!countryRecorder.containsKey(continent)){
                countryRecorder.put(continent, new LinkedHashMap<>(){{put(country, new ArrayList<>(){{add(city);}});}});
            }else {
                if (!countryRecorder.get(continent).containsKey(country)){
                    countryRecorder.get(continent).put(country, new ArrayList<>(){{add(city);}});
                }else {
                    countryRecorder.get(continent).get(country).add(city);
                }
            }
        }
        countryRecorder.forEach((key, value) -> {
            System.out.println(String.format("%s:", key));
            value.forEach((key1, value1) -> {
                System.out.print(String.format("  %s -> ", key1));

                System.out.print(String.join(", ", value1));

                System.out.println();
            });
        });

    }
}
