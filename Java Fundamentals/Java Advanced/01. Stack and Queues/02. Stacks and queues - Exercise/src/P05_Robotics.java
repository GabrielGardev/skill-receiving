import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P05_Robotics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] namesAndProcessTime = reader.readLine().split(";");
        String[] names = new String[namesAndProcessTime.length];
        int[] processTimeForRobot = new int[namesAndProcessTime.length];
        int[] process = new int[namesAndProcessTime.length];


        for (int i = 0; i < namesAndProcessTime.length; i++) {
            names[i] = namesAndProcessTime[i].split("-")[0];
            processTimeForRobot[i] = Integer.parseInt(namesAndProcessTime[i].split("-")[1]);
        }
        int[] inputTime = Arrays.stream(reader.readLine().split(":")).mapToInt(Integer::parseInt).toArray();

        int time = inputTime[0] * 3600 + inputTime[1] * 60 + inputTime[2];

        ArrayDeque<String> products = new ArrayDeque<>();
        while (true){
            String product = reader.readLine();
            if (product.equals("End")){
                break;
            }
            products.offer(product);
        }

        while (!products.isEmpty()) {
            time++;
            boolean allBusy = true;

            for (int i = 0; i < process.length; i++) {
                if (process[i] > 0){
                    process[i]--;
                }
            }

            for (int i = 0; i < names.length; i++) {
                if (process[i] == 0){
                    String product = products.poll();
                    process[i] = processTimeForRobot[i];
                    printResult(names[i], product, time);
                    allBusy = false;
                    break;
                }
            }
            if (allBusy){
                products.offer(products.poll());
            }
        }
    }

    private static void printResult(String name, String product, int time) {

        int s = time % 60;
        int m = (time/ 60) % 60;
        int h = (time / (60 * 60)) % 24;


        DecimalFormat df = new DecimalFormat("00");
        System.out.println(String.format("%s - %s [%s:%s:%s]", name, product,
                df.format(h),df.format(m),df.format(s)));
    }
}
