package P02_Collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> input = Arrays.stream(reader.readLine().split(" "))
                .skip(1)
                .collect(Collectors.toCollection(ArrayList::new));

        ListyIterator<String> listyIterator = new ListyIterator(input);

        while (true){
            String line = reader.readLine();
            if (line.equals("END")){
                break;
            }

            switch (line){
                case "Move":
                    System.out.println(listyIterator.Move());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.HasNext());
                    break;
                case "Print":
                    listyIterator.PrintAtCurrentIndex();
                    break;
                case "PrintAll":
                    for (String s : listyIterator) {
                        System.out.print(s + " ");
                    }
                    System.out.println();
                    break;
            }
        }
    }
}
