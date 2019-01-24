import java.util.Scanner;

public class P1_Data_Types {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        switch (type){
            case "int":
                int num = Integer.parseInt(scanner.nextLine());
                ChangeTheInput(num);
                break;
            case "real":
                double realNum = Double.parseDouble(scanner.nextLine());
                ChangeTheInput(realNum);
                break;
            case "string":
                String word = scanner.nextLine();
                ChangeTheInput(word);
                break;
        }
    }

    private static void ChangeTheInput(String word) {
        System.out.println("$" + word + "$");
    }

    private static void ChangeTheInput(double realNum) {
        System.out.printf("%.2f", realNum * 1.5);
    }

    private static void ChangeTheInput(int num) {
        System.out.println(num * 2);
    }
}
