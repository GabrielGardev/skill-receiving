import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P3_Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> ppl = Arrays.stream(scanner.nextLine().split(",\\s+")).collect(Collectors.toList());

        Map<String, Integer> racers = new LinkedHashMap<>();

        for (String aPpl : ppl) {
            racers.putIfAbsent(aPpl, 0);
        }

        while (true){
            String line = scanner.nextLine();
            if (line.equals("end of race")){
                break;
            }
            String name = "";
            int sum = 0;
            for (int i = 0; i < line.length(); i++) {
                char currentChar = line.charAt(i);

                if (Character.isDigit(currentChar)){
                    int num = Integer.parseInt(currentChar + "");
                    sum += num;
                }else if (Character.isAlphabetic(currentChar)){
                    name += currentChar;
                }
            }
            if (racers.containsKey(name)){
                racers.put(name, racers.get(name) + sum);
            }
        }
        List<String> finalist = new ArrayList<>();
        racers.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
               .limit(3)
                .forEach(x -> {
                    finalist.add(x.getKey());
                });

            System.out.println(String.format("1st place: %s", finalist.get(0)));
            System.out.println(String.format("2nd place: %s", finalist.get(1)));
            System.out.println(String.format("3rd place: %s", finalist.get(2)));
    }
}
