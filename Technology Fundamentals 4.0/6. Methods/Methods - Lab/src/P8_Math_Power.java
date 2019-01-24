import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class P8_Math_Power {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal num = new BigDecimal(Double.parseDouble(scanner.nextLine()));
        int power = Integer.parseInt(scanner.nextLine());
        DecimalFormat format = new DecimalFormat("###.######");
        System.out.println(format.format(PowerOfNum(num, power)));
    }

    public static BigDecimal PowerOfNum(BigDecimal num, int power) {
        BigDecimal result = num;
        result = result.pow(power);

        return result;
    }
}
