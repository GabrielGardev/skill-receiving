import java.util.Scanner;

public class P1_Valid_Usernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] line = scanner.nextLine().split(", ");

        for (int i = 0; i < line.length; i++) {
            String userName = line[i];

            boolean isItValid = true;
            if (userName.length() >= 3 && userName.length() <= 16){
                for (int j = 0; j < userName.length(); j++) {
                    char currentChar = userName.charAt(j);

                    if (Character.isAlphabetic(currentChar) || Character.isDigit(currentChar) || currentChar == '-'
                    || currentChar == '_'){

                    }else {
                        isItValid = false;
                        break;
                    }
                }
            }else {
                isItValid = false;
            }
            if (isItValid){
                System.out.println(userName);
            }
        }
    }
}
