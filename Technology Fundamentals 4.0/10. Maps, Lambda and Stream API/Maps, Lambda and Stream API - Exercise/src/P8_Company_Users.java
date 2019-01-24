import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P8_Company_Users {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, ArrayList<String>> company = new TreeMap<>();

        while (true){
            String[] line = scanner.nextLine().split(" -> ");
            if (line[0].equals("End")){
                break;
            }
            String companyName = line[0];
            String employeeID = line[1];

            if (company.containsKey(companyName) == false){
                company.put(companyName, new ArrayList<>());
            }
            if (company.get(companyName).contains(employeeID) == false){
                company.get(companyName).add(employeeID);
            }

        }
        company.entrySet().stream()
                .forEach(x -> {
                    System.out.println(x.getKey());
                    x.getValue().forEach(e -> System.out.println("-- " + e));
                });
    }
}
