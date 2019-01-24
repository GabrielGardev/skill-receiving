import java.util.Scanner;

public class P4_Password_Validator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        PrintMessage(password);
    }

    private static void PrintMessage(String password) {
        boolean checker = true;
        if (!ReturnCharactersLenght(password)){
            System.out.println("Password must be between 6 and 10 characters");
            checker = false;
        }
        if (!ReturnLettersAndDigitsOnly(password)){
            System.out.println("Password must consist only of letters and digits");
            checker = false;
        }
        if (!ReturnDigitsCheker(password)){
            System.out.println("Password must have at least 2 digits");
            checker = false;
        }
        if (checker){
            System.out.println("Password is valid");
        }
    }

    private static boolean ReturnDigitsCheker(String password) {
        int counter = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 48 && password.charAt(i) <= 57){
                counter++;
            }
            if (counter == 2){
                return true;
            }
        }
        return false;
    }

    private static boolean ReturnLettersAndDigitsOnly(String password) {

        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 48 && password.charAt(i) <= 57){

            }else if (password.charAt(i) >= 65 && password.charAt(i) <= 90){

            }else if(password.charAt(i) >= 97 && password.charAt(i) <= 122){

            }else {
                return false;
            }
        }
        return true;
    }

    private static boolean ReturnCharactersLenght(String password){

        if (password.length() >= 6 && password.length() <= 10){
            return true;
        }
        return false;
    }
}
