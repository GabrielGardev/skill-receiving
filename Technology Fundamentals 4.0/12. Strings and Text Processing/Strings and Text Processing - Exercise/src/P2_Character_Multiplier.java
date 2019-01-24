import java.util.Scanner;

public class P2_Character_Multiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] line = scanner.nextLine().split(" ");

        System.out.println(CharacterMultiplier(line[0], line[1]));
    }

    private static Integer CharacterMultiplier(String s, String s1) {
        int sum = 0;
        int min =  Math.min(s.length(), s1.length());

        for (int i = 0; i < min; i++) {
                int first = s.charAt(i);
                int second = s1.charAt(i);

                sum += first * second;
        }
        if (s.length() > s1.length()){
            for (int i = s1.length(); i < s.length(); i++) {
                sum += s.charAt(i);
            }
        }else if (s1.length() > s.length()){
            for (int i = s.length(); i < s1.length(); i++) {
                sum += s1.charAt(i);
            }
        }
        return sum;
    }
}
