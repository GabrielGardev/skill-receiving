import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06_A_Miner_Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Long> mine = new LinkedHashMap<>();
        while (true){
            String resource = scanner.nextLine();
            if (resource.equals("stop")){
                break;
            }
            Long quantity = Long.parseLong(scanner.nextLine());

            if (!mine.containsKey(resource)){
                mine.put(resource, quantity);
            }else {
                mine.put(resource, mine.get(resource) + quantity);
            }
        }
        mine.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
