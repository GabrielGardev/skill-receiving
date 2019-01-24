import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P4_SoftUni_Bar_Income {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalIncome = 0;
        while (true){
            String line = scanner.nextLine();
            if (line.equals("end of shift")){
                break;
            }

            Pattern pattern = Pattern.compile
                    ("%(?<name>[A-Z][a-z]+)%(.+)?<(?<product>\\w+)>(.+)?\\|(?<count>\\d+)\\|(.+)?(?<!\\d|\\.)(?<price>\\d+(\\.\\d+)?)\\$");

            Matcher matcher = pattern.matcher(line);
            if (matcher.find()){
                double price = Double.parseDouble(matcher.group("count")) * Double.parseDouble(matcher.group("price"));
                totalIncome += price;
                System.out.println(String.format("%s: %s - %.2f", matcher.group("name"),
                        matcher.group("product"), price));
            }
        }
        System.out.println(String.format("Total income: %.2f", totalIncome));
    }
}
