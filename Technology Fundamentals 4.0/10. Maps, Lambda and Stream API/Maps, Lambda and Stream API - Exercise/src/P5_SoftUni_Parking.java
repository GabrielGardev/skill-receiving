import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P5_SoftUni_Parking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String,String> users = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            String username = line[1];

            if (line[0].equals("register")){
                String license = line[2];

                if (!users.containsKey(username)){
                    users.put(username, license);
                    System.out.println(username + " registered " + license + " successfully");
                }else {
                    System.out.printf("ERROR: already registered with plate number %s%n", license);
                }
            }else if (line[0].equals("unregister")){

                if (users.containsKey(username) == false){
                    System.out.printf("ERROR: user %s not found%n", username);
                }else {
                    users.remove(username);
                    System.out.printf("%s unregistered successfully%n", username);
                }
            }
        }
        for (Map.Entry<String, String> entry : users.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
