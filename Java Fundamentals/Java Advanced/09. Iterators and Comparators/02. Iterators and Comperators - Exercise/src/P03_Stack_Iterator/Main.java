package P03_Stack_Iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack();

        while (true){
            String[] line = reader.readLine().split("\\s+");
            if (line[0].equals("END")){
                break;
            }

            if (line[0].equals("Push")){
                String result = "";
                for (String s : line) {
                   result += s;
                }
                result = result.substring(4);
                int[] array = Arrays.stream(result.split(",")).mapToInt(Integer::parseInt).toArray();
                for (int i : array) {
                    stack.push(i);
                }
            }else if (line[0].equals("Pop")){
                try {
                    stack.pop();
                }catch (Exception e){
                    System.out.println("No elements");
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            for (Integer integer : stack) {
                System.out.println(integer);
            }
        }
    }
}
