import java.util.*;

public class P1_Concert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> bandsAndMembers = new LinkedHashMap<>();
        Map<String, Long> bandsAndTime = new TreeMap<>();
        while (true){
            String line = scanner.nextLine();
            if (line.equals("start of concert")){
                break;
            }
            String[] input = line.split("; ");
            String command = input[0];
            String bandName = input[1];

            if (command.equals("Add")){
                String[] members = input[2].split(", ");
                bandsAndMembers.putIfAbsent(bandName, new ArrayList<>());
                for (String member : members) {
                    if (!bandsAndMembers.get(bandName).contains(member)){
                        bandsAndMembers.get(bandName).add(member);
                    }
                }
            }else if (command.equals("Play")){
                long time = Long.parseLong(input[2]);

                if (bandsAndTime.containsKey(bandName)){
                    bandsAndTime.put(bandName, bandsAndTime.get(bandName) + time);
                }else {
                    bandsAndTime.put(bandName, time);
                }
            }
        }
        long sum = 0;
        for (Long value : bandsAndTime.values()) {
            sum += value;
        }
        System.out.println(String.format("Total time: %d", sum));

        bandsAndTime.entrySet().stream()
                .sorted((a,b) -> b.getValue().compareTo(a.getValue()))
                .forEach(x -> {
                    System.out.println(String.format("%s -> %d", x.getKey(), x.getValue()));
                });

        String bandName = scanner.nextLine();
        System.out.println(bandName);
        bandsAndMembers.get(bandName).forEach(x -> {
            System.out.println(String.format("=> %s", x));
        });
    }
}
