import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P6_Nether_Realms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(",\\s*");
        List<Demon> demons = new ArrayList<>();

        for (String demon : line) {
            demon = demon.trim();
            Demon demon1 = new Demon();
            demon1.setName(demon);

            Pattern pattern = Pattern.compile("[^\\d\\+\\-\\*\\/\\.]");
            Matcher matcher = pattern.matcher(demon);
            long hp = 0;

            while (matcher.find()) {
                char currentChar = matcher.group().charAt(0);
                hp += currentChar;
            }
            demon1.setHealth(hp);

            Pattern pattern1 = Pattern.compile("-?\\d*\\.?\\d+");
            Matcher matcher1 = pattern1.matcher(demon);
            double dmg = 0;

            while (matcher1.find()) {
                String temp = matcher1.group();

                double num = Double.parseDouble(temp);
                dmg += num;
            }

            for (int i = 0; i < demon.length(); i++) {
                char currentChar = demon.charAt(i);

                if (currentChar == '*') {
                    dmg *= 2;
                } else if (currentChar == '/') {
                    dmg /= 2;
                }
            }

            demon1.setDmg(dmg);
            demons.add(demon1);
        }
        demons.stream()
                .sorted(Comparator.comparing(Demon::getName))
                .forEach(d -> {
                    System.out.println(String.format("%s - %d health, %.2f damage", d.getName(), d.getHealth(), d.getDmg()));
                });
    }

    static class Demon {
        private String name;
        private long health;
        private double dmg;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getHealth() {
            return health;
        }

        public void setHealth(long health) {
            this.health = health;
        }

        public double getDmg() {
            return dmg;
        }

        public void setDmg(double dmg) {
            this.dmg = dmg;
        }
    }
}
