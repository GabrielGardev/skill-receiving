import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class P1_Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String str = scanner.nextLine();
        StringBuilder sb = new StringBuilder(str);

        String result = "";

        for (int i = 0; i < numbers.size(); i++) {
            int currentNum = numbers.get(i);
            int sum = 0;

            while (currentNum > 0){
                sum += currentNum % 10;
                currentNum /= 10;
            }


            while (true){
                if (sum >= str.length()){
                    sum -= str.length();
                }else {
                    result += sb.charAt(sum);
                    sb.deleteCharAt(sum);
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
