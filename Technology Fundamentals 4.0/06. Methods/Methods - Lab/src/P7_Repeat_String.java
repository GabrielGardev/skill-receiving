import java.util.Scanner;

public class P7_Repeat_String {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stringToRepeat = scanner.nextLine();
        int times = Integer.parseInt(scanner.nextLine());
        System.out.println(RepeatStr(stringToRepeat, times));
    }
    public static StringBuilder RepeatStr (String stringToRepeat,int times){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            builder.append(stringToRepeat);
        }
        return builder;
    }
}
