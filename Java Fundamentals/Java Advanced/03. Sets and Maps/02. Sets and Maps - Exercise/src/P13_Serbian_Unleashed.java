import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P13_Serbian_Unleashed {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String , LinkedHashMap<String, Integer>> register = new LinkedHashMap<>();

        while (true){
            String line = reader.readLine();
            if (line.equals("End")){
                break;
            }
            String [] newLine = new String[2];
            String singer;
            String rest;
            try {
                newLine = line.split(" @");
                singer = newLine[0];
                rest = "@" + newLine[1];
            }catch (Exception e){
                continue;
            }


            Pattern pattern = Pattern.compile("^@(?<venue>[A-Za-z ]+)\\s(?<price>\\d+)\\s(?<count>\\d+)$");
            Matcher matcher = pattern.matcher(rest);

            if (matcher.find()){
                String venue = matcher.group("venue");
                int totalMoney = Integer.parseInt(matcher.group("price"))
                        * Integer.parseInt(matcher.group("count"));

                if (!register.containsKey(venue)){
                    register.put(venue, new LinkedHashMap<>(){{
                        put(singer, totalMoney);
                    }});
                }else {
                    if (!register.get(venue).containsKey(singer)){
                        register.get(venue).put(singer, totalMoney);
                    }else {
                        register.get(venue).put(singer, register.get(venue).get(singer) + totalMoney);
                    }
                }
            }
        }
        register.forEach((key, value) -> {
            System.out.println(key);
            value.entrySet().stream()
                    .sorted((a,b) -> b.getValue().compareTo(a.getValue()))
                    .forEach(x -> {
                        System.out.println(String.format("#  %s -> %d", x.getKey(), x.getValue()));
                    });
        });
    }
}
