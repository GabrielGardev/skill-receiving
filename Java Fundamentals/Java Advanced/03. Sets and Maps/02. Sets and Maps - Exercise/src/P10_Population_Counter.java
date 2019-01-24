import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P10_Population_Counter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, LinkedHashMap<String, Long>> register = new LinkedHashMap<>();

        while (true) {
            String[] input = reader.readLine().split("\\|");
            if ("report".equals(input[0])) {
                break;
            }
            String city = input[0];
            String country = input[1];
            long population = Long.parseLong(input[2]);

            if (!register.containsKey(country)) {
                register.put(country, new LinkedHashMap<>(){{
                    put(city, population);
                }});
            } else {
                register.get(country).put(city, population);
            }
        }
        register.entrySet().stream().sorted((a, b) -> {
            long tempB = b.getValue().values().stream().mapToLong(Long::longValue).sum();
            long tempA = a.getValue().values().stream().mapToLong(Long::longValue).sum();

            return Long.compare(tempB, tempA);
        }).forEach(x -> {
            System.out.println(String.format("%s (total population: %d)", x.getKey(), x.getValue().values()
            .stream().mapToLong(Long::longValue).sum()));
            x.getValue().entrySet().stream()
                    .sorted((a,b) -> Long.compare(b.getValue(), a.getValue()))
                    .forEach(e -> {
                        System.out.println(String.format("=>%s: %d", e.getKey(), e.getValue()));
                    });
        });
    }
}
