import java.util.Scanner;

public class P9_Poke_Mon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long pokePower = Long.parseLong(scanner.nextLine());
        long distance = Long.parseLong(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());
        long originalValue = pokePower;

        int pokedTargets = 0;

        while (pokePower >= distance){
            pokePower -= distance;
            pokedTargets++;

            if (pokePower == originalValue * 0.5){
                if (exhaustionFactor > 0){
                    pokePower /= exhaustionFactor;
                }
            }
        }
        System.out.println(pokePower);
        System.out.println(pokedTargets);
    }
}
