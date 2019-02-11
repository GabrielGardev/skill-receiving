import java.util.Scanner;

public class P9_Greater_of_Two_Values {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        String first = scanner.nextLine();
        String second = scanner.nextLine();

        if (type.equals("int")) {
            int firstNum = Integer.parseInt(first);
            int secondNum = Integer.parseInt(second);
            System.out.println(GetMax(firstNum, secondNum));
        }  else if (type.equals("char")) {
            char firstC = first.charAt(0);
            char secondC = second.charAt(0);
            System.out.println(GetMax(firstC, secondC));
        } else {
            System.out.println(GetMax(first, second));
        }
    }
     static char GetMax(char first, char second) {
        if (first > second){
            return first;
        }
        return second;
    }

     static String GetMax(String first, String second) {
        if (first.compareTo(second) >= 0){
            return first;
        }
        return second;
    }

     static int GetMax(int first, int second) {
        if (first > second){
            return first;
        }
        return second;
    }
}
