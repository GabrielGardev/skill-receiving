import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P2_Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> furnitures = new ArrayList<>();
        double totalPrice = 0;

        while (true){
            String line = scanner.nextLine();
            if (line.equals("Purchase")){
                break;
            }

            Pattern pattern = Pattern.compile
                    (">>(?<name>.+)<<(?<price>\\d+(\\.\\d+)?)!(?<quantity>\\d+)");
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()){
                double price = Double.parseDouble(matcher.group("price")) * Double.parseDouble(matcher.group("quantity"));
                String name = matcher.group("name");

                furnitures.add(name);
                totalPrice += price;
            }
        }
            System.out.println("Bought furniture:");
            for (var furniture : furnitures) {
                System.out.println(furniture);
            }
            System.out.println(String.format("Total money spend: %.2f", totalPrice));
    }
}
