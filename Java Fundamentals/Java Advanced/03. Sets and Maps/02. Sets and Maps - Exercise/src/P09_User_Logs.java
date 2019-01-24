import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P09_User_Logs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, LinkedHashMap<String, Integer>> site = new TreeMap<>();
        String[] input = reader.readLine().split(" ");
        String user;
        String ip = "";

        while (!input[0].equals("end"))
        {
            String[] takeUser = input[2].split("=");
            user = takeUser[1];

            String[] takeIp = input[0].split("=");
            ip = takeIp[1];

            if (!site.containsKey(user))
            {
                String finalIp = ip;
                site.put(user, new LinkedHashMap<>(){{put(finalIp, 1);}});
            }
            else
            {
                if (!site.get(user).containsKey(ip))
                {
                    site.get(user).put(ip, 1);
                }
                else
                {
                    site.get(user).put(ip, site.get(user).get(ip) + 1);
                }
            }
            input = reader.readLine().split(" ");
        }
        for (var entry : site.entrySet()) {
            System.out.println(String.format("%s:", entry.getKey()));
            List<String> temp = new ArrayList<>();

            entry.getValue().forEach((key, value) -> {
                temp.add(String.format("%s => %d", key, value));
            });
            System.out.println(String.join(", ", temp) + ".");

        }
    }
}
