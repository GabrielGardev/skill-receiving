import java.util.ArrayDeque;
import java.util.Scanner;

public class P05_Printer_Queue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> printerQueue = new ArrayDeque<>();
        while (true){
            String line = scanner.nextLine();
            if (line.equals("print")){
                break;
            }

            if (line.equals("cancel")){
                if (printerQueue.isEmpty()){
                    System.out.println("Printer is on standby");
                }else {
                    System.out.println("Canceled " + printerQueue.pollFirst());
                }
            }else {
                printerQueue.offer(line);
            }
        }
        while (printerQueue.size() != 0){
            System.out.println(printerQueue.poll());
        }
    }
}
