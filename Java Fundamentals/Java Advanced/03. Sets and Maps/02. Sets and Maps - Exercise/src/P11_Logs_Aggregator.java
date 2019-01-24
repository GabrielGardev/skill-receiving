import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class P11_Logs_Aggregator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String , TreeMap<String, Integer>> register = new TreeMap<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("\\s+");
            String user = line[1];
            String IP = line[0];
            int duration = Integer.parseInt(line[2]);

            if (!register.containsKey(user)){
                register.put(user, new TreeMap<>(){{
                    put(IP, duration);
                }});
            }else {
                if (!register.get(user).containsKey(IP)){
                    register.get(user).put(IP, duration);
                }else {
                    register.get(user).put(IP, register.get(user).get(IP) + duration);
                }
            }
        }
        register.forEach((key, value) -> {
            final int[] sum = {0};
            List<String> temp = new ArrayList<>();
            value.forEach((key1,value1) -> {
                sum[0] += value1;
                temp.add(key1);
            });
            System.out.println(String.format("%s: %d [%s]", key, sum[0], String.join(", ", temp)));

        });
    }
}
