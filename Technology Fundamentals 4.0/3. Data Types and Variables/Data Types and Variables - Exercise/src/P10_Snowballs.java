import java.util.Scanner;

public class P10_Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double maxValue = 0;
        int snowballSnow = 0, snowballTime = 0, snowballQuality = 0;


        for (int i = 0; i < n; i++) {
            int snow = Integer.parseInt(scanner.nextLine());
            int time = Integer.parseInt(scanner.nextLine());
            int quality = Integer.parseInt(scanner.nextLine());

            double value = Math.pow((snow / time), quality);

            if (value > maxValue){
                maxValue = value;
                snowballSnow = snow;
                snowballTime = time;
                snowballQuality = quality;
            }
        }

        System.out.printf("%d : %d = %.0f (%d)", snowballSnow, snowballTime, maxValue , snowballQuality);
    }
}
