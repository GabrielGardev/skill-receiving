package P01_Socks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> leftStack = new ArrayDeque<>();
        ArrayDeque<Integer> rightDeque = new ArrayDeque<>();

        List<Integer> pairs = new ArrayList<>();

        Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(leftStack::push);

        Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(rightDeque::offer);

        while (!leftStack.isEmpty() && !rightDeque.isEmpty()){
            int leftSock = leftStack.peek();
            int rightSock = rightDeque.peek();

            if (leftSock == rightSock){
                rightDeque.poll();
                leftStack.pop();
                leftSock++;
                leftStack.push(leftSock);
            }else if (rightSock > leftSock){
                leftStack.pop();
            }else {
                //pair
                pairs.add(leftStack.pop()+ rightDeque.poll());
            }
        }
        System.out.println(pairs.stream().max(Integer::compareTo).get());
        pairs.forEach(x -> System.out.print(x + " "));
    }
}
