import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.stream.Collectors;

public class P4_Tower_of_Hanoi {
    public static StringBuilder sb = new StringBuilder();

    public static Deque<Integer> source = new ArrayDeque<>();
    public static Deque<Integer> destination = new ArrayDeque<>();
    public static Deque<Integer> spare = new ArrayDeque<>();
    public static int steps = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int disk = Integer.parseInt(reader.readLine());

        for (int i = disk; i >= 1; i--) {
            source.push(i);
        }

        printRods();
        solve(disk, source, destination, spare);
        System.out.println(sb);
    }

    private static void solve(int disk, Deque<Integer> source, Deque<Integer> destination, Deque<Integer> spare) {
        if (disk == 1){
            destination.push(source.pop());
            sb.append("Step #").append(++steps).append(": Moved disk").append(System.lineSeparator());
            printRods();
        }else {
            solve(disk - 1, source, spare, destination);
            solve(1, source, destination, spare);
            solve(disk - 1, spare, destination, source);
        }
    }

    public static void printRods(){
        sb.append("Source: ").append(formatRod(source)).append(System.lineSeparator())
                .append("Destination: ").append(formatRod(destination)).append(System.lineSeparator())
                .append("Spare: ").append(formatRod(spare)).append(System.lineSeparator())
                .append(System.lineSeparator());
    }

    public static String formatRod(Deque<Integer> stack){
        return stack.stream()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
