import java.util.*;

public class P12_Legendary_Farming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var keyMaterials = new HashMap<String, Integer>() {{
            this.put("shards", 0);
            this.put("fragments", 0);
            this.put("motes", 0);
        }};

        var junkMaterials = new TreeMap<String, Integer>();
        int quantity;
        String type = "";
        String legendary = "";
        boolean isItDone = false;

        while (!isItDone)
        {
            String[] input = scanner.nextLine().toLowerCase().split(" ");

            for (int i = 0; i < input.length; i += 2)
            {
                quantity = Integer.parseInt(input[i]);
                type = input[i + 1];

                if (type.equals("shards") || type.equals("fragments") || type.equals("motes"))
                {
                    keyMaterials.put(type, keyMaterials.get(type) + quantity);
                    if (keyMaterials.get(type) >= 250)
                    {
                        keyMaterials.put(type, keyMaterials.get(type) - 250);
                        isItDone = true;
                        break;
                    }
                }
                else
                {
                    if (!junkMaterials.containsKey(type))
                    {
                        junkMaterials.put(type, 0);
                    }
                    junkMaterials.put(type, junkMaterials.get(type) + quantity);
                }
            }
        }
        switch (type)
        {
            case "fragments":
                legendary = "Valanyr";
                break;
            case "shards":
                legendary = "Shadowmourne";
                break;
            case "motes":
                legendary = "Dragonwrath";
                break;
        }

        System.out.println(legendary + " obtained!");
        keyMaterials.entrySet()
                .stream()
                .sorted((a , b) ->{
                    if (b.getValue().compareTo(a.getValue()) == 0){
                        return a.getKey().compareTo(b.getKey());
                    }
                    return b.getValue().compareTo(a.getValue());
                })
                .forEach(x -> System.out.println(x.getKey() + ": " + x.getValue()));

        junkMaterials.forEach((key, value) -> System.out.println(key + ": " + value));

    }
}
