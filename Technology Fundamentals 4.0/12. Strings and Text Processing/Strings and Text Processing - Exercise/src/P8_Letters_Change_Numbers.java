import java.util.Scanner;

public class P8_Letters_Change_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] line = scanner.nextLine().split("\\s+");

        double sum = 0;
        for (String s : line) {
            double num = Double.parseDouble(s.substring(1, s.length() - 1));
            char firstLetter = s.charAt(0);
            char lastLetter = s.charAt(s.length() - 1);


            if (Character.isUpperCase(firstLetter)){
                num /= firstLetter - 64;
            }else if(Character.isLowerCase(firstLetter)) {
                num *= firstLetter - 96;
            }

            if (Character.isUpperCase(lastLetter)) {
                num -= lastLetter - 64;
            } else if (Character.isLowerCase(lastLetter)) {
                num += lastLetter - 96;
            }

            sum+= num;
        }
        System.out.println(String.format("%.2f", sum));
    }
}
