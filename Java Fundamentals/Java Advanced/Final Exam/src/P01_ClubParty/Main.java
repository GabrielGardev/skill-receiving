package P01_ClubParty;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;
        import java.util.concurrent.atomic.AtomicInteger;
        import java.util.concurrent.atomic.AtomicReference;
        import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<LinkedHashMap<String , ArrayList<Integer>>> deque = new ArrayDeque<>();

        int capacity = Integer.parseInt(reader.readLine());

        Arrays.stream(reader.readLine().split("\\s+"))
                .forEach(stack::push);

        while (!stack.isEmpty()){
            try {
                int peoples = Integer.parseInt(stack.peek());
                if (!deque.isEmpty()){
                    AtomicInteger sum = new AtomicInteger();
                    deque.peek().values().forEach(x ->  x.forEach(sum::addAndGet));

                    if (peoples + sum.get() > capacity){
                        LinkedHashMap<String, ArrayList<Integer>> temp = deque.poll();
                        temp.forEach((key, value) -> {
                            System.out.print(key + " -> ");
                            ArrayList<String> str = value.stream()
                                    .map(n -> n + "")
                                    .collect(Collectors.toCollection(ArrayList::new));
                            System.out.println(String.join(", ", str));
                        });
                        continue;
                    }else {
                        AtomicReference<String> currentKey = new AtomicReference<>("");
                        deque.peek().keySet().forEach(currentKey::set);
                        ArrayList<Integer> temp = deque.peek().get(currentKey.get());
                        temp.add(peoples);
                        deque.peek().put(currentKey.get(), temp);
                    }
                }
            }catch (Exception e){
                String hall = stack.peek();
                LinkedHashMap<String, ArrayList<Integer>> temp = new LinkedHashMap<>();
                temp.put(hall, new ArrayList<>());

                deque.offer(temp);
            }

            stack.pop();
        }

    }
}
