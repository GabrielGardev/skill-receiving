package P02_Excel_Functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());

        ArrayList<ArrayList<String>> table = new ArrayList<>();
        fillMatrix(table, rows, reader);

        String[] command = reader.readLine().split("\\s+");
        switch (command[0]){
            case "hide":
                String header = command[1];
                hide(table, header);
                break;
            case "sort":
                String header1 = command[1];
                sorting(table, header1);
                break;
            case "filter":
                String header2 = command[1];
                String value = command[2];
                table = printSearchedItem(table, header2, value);
                break;
        }
        printMatrix(table);
    }
    private static void printMatrix(ArrayList<ArrayList<String >> matrix) {

        for (ArrayList<String> list : matrix) {
            System.out.println(String.join(" | ",list));
        }
    }

    private static ArrayList<ArrayList<String>> printSearchedItem(ArrayList<ArrayList<String>> table, String header2, String value) {
        ArrayList<ArrayList<String>> temp = new ArrayList<>();

        if (table.get(0).contains(header2)){
            temp.add(table.get(0));
            int targetCol = table.get(0).indexOf(header2);
            for (ArrayList<String> list : table) {
                if (list.get(targetCol).equals(value)){
                    temp.add(list);
                }
            }
        }
        return temp;
    }

    private static void sorting(ArrayList<ArrayList<String>> table, String header) {
        //maybe integer need to be parsed
        if (table.get(0).contains(header)){
            int targetCol = table.get(0).indexOf(header);
            ArrayList<String> temp = table.remove(0);

           table.sort(Comparator.comparing(a -> a.get(targetCol)));
           table.add(0, temp);
        }
    }

    private static void hide(ArrayList<ArrayList<String>> table, String header) {
        if (table.get(0).contains(header)){
            int targetCol = table.get(0).indexOf(header);
            for (ArrayList<String> list : table) {
                list.remove(targetCol);
            }
        }
    }

    private static void fillMatrix(ArrayList<ArrayList<String>> matrix, int rows, BufferedReader reader) throws IOException {
        for (int i = 0; i < rows; i++) {
            matrix.add(i, Arrays.stream(reader.readLine().split(", ")).collect(Collectors.toCollection(ArrayList::new)));
        }
    }
}
