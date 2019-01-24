import java.util.*;

public class P5_Dragon_Army {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, TreeMap<String, int[]>> dragons = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[] data = scanner.nextLine().split("\\s+");
            String type = data[0];
            String name = data[1];
            int dmg = 45;
            int health = 250;
            int armor = 10;

            if (!data[2].equals("null")) {
                dmg = Integer.parseInt(data[2]);
            }

            if (!data[3].equals("null")) {
                health = Integer.parseInt(data[3]);
            }

            if (!data[4].equals("null")) {
                armor = Integer.parseInt(data[4]);
            }

            if (!dragons.containsKey(type)) {

                dragons.put(type, new TreeMap<>());
            }
            dragons.get(type).put(name, new int[]{dmg, health, armor});
        }

        dragons.forEach((key1, value1) -> {

            System.out.print(key1 + "::");
            List<Integer> allDragonsDmg = new ArrayList<>();
            List<Integer> allDragonsHealth = new ArrayList<>();
            List<Integer> allDragonsArmor = new ArrayList<>();

            value1.forEach((key, value) -> {
                allDragonsDmg.add(value[0]);
                allDragonsHealth.add(value[1]);
                allDragonsArmor.add(value[2]);
            });

            double avgDmg = allDragonsDmg.stream().mapToDouble(Integer::doubleValue).average().getAsDouble();
            double avgHP = allDragonsHealth.stream().mapToDouble(Integer::doubleValue).average().getAsDouble();
            double avgArmor = allDragonsArmor.stream().mapToDouble(Integer::doubleValue).average().getAsDouble();
            System.out.printf("(%.2f/%.2f/%.2f)%n", avgDmg, avgHP, avgArmor);

            value1.forEach((key, value) -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                    key, value[0], value[1], value[2]));
        });
    }
}