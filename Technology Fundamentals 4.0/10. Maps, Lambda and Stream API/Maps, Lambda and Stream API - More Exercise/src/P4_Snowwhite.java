import java.util.*;

public class P4_Snowwhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Dwarf> dwarves = new ArrayList<>();
        LinkedHashMap<String, Integer> colorAndCount = new LinkedHashMap<>();
        while (true) {
            String[] line = scanner.nextLine().split(" <:> ");
            if (line[0].equals("Once upon a time")) {
                break;
            }
            String name = line[0];
            String color = line[1];
            int physics = Integer.parseInt(line[2]);

            Dwarf dwarf = new Dwarf(name, physics, color, 1);

            boolean hasAdded = false;
            boolean hasSameNameAndColor = false;

            for (Dwarf unit : dwarves) {
                if (unit.Name.equals(dwarf.Name)) {
                    if (unit.Color.equals(dwarf.Color)) {
                        hasSameNameAndColor = true;
                        if (dwarf.Physics > unit.Physics) {
                            unit.Physics = dwarf.Physics;
                            hasAdded = true;
                            break;
                        }
                    }
                }
            }
            if (!hasAdded && !hasSameNameAndColor) {
                dwarves.add(dwarf);

                if (!colorAndCount.containsKey(color)) {
                    colorAndCount.put(color, 0);
                }

                colorAndCount.put(color, colorAndCount.get(color) + 1);
            }
        }
        for (Dwarf unit : dwarves) {
            for (var color : colorAndCount.entrySet()) {
                if (unit.Color.equals(color.getKey())) {
                    unit.ColorCount = color.getValue();
                }
            }
        }

        dwarves.stream().sorted((e1, e2) -> {

            int result = Integer.compare(e2.Physics, e1.Physics);

            if (result == 0) {

                result = Integer.compare(e2.ColorCount, e1.ColorCount);
            }

            return result;
        }).forEach(x -> System.out.printf("(%s) %s <-> %d%n", x.Color, x.Name, x.Physics));
    }


    static class Dwarf {
        public String Name;
        public int Physics;
        public String Color;
        public int ColorCount;

        public Dwarf(String name, int physics, String color, int colorCount) {

            Name = name;
            Physics = physics;
            Color = color;
            ColorCount = colorCount;
        }
    }
}
