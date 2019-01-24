import java.lang.reflect.Array;
import java.util.*;

public class P9_ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, ArrayList<String>> sides = new TreeMap<>();
        while (true){
            String input = scanner.nextLine();
            if (input.equals("Lumpawaroo")){
                break;
            }

            if (input.contains("|")){
                String[] line = input.split(" \\| ");
                String forceSide = line[0];
                String forceUser = line[1];

                boolean isItPresent = false;
                for (String s : sides.keySet()) {
                    if (sides.get(s).contains(forceUser)){
                        isItPresent = true;
                    }
                }

                if (isItPresent == false){
                    sides.putIfAbsent(forceSide, new ArrayList<>());
                    sides.get(forceSide).add(forceUser);
                }
            }else {
                String[] line = input.split(" -> ");
                String forceSide = line[1];
                String forceUser = line[0];

                boolean isItPresent = false;
                for (String s : sides.keySet()) {
                    if (sides.get(s).contains(forceUser)) {
                        sides.get(s).remove(forceUser);
                        isItPresent = true;
                    }
                }

                sides.putIfAbsent(forceSide, new ArrayList<>());
                sides.get(forceSide).add(forceUser);
                System.out.println(forceUser + " joins the " + forceSide + " side!");

            }
        }
        sides.entrySet().stream()
                .filter(s -> s.getValue().size() > 0)
                .sorted((a, b) -> {
                    if (b.getValue().size() - a.getValue().size() == 0){
                        return a.getKey().compareTo(b.getKey());
                    }
                    return b.getValue().size() - a.getValue().size();
                })
                .forEach(x ->{
                    System.out.printf("Side: %s, Members: %d%n", x.getKey(), x.getValue().size());
                    x.getValue().stream().sorted().forEach(user -> System.out.println("! " + user));
                });
    }
}