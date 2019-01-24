import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class P08_Simple_Text_Editor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<String> lastCommands = new ArrayDeque<>();
        StringBuilder currentString = new StringBuilder();

        int n = Integer.parseInt(reader.readLine());

        lastCommands.push(currentString.toString());
        for (int i = 0; i < n; i++) {
            String[] command = reader.readLine().split("\\s+");

            if (command[0].equals("1")){
                String textToAppend = command[1];
                currentString.append(textToAppend);
                lastCommands.push(currentString.toString());
            }else if (command[0].equals("2")){
                int startIndex = currentString.length() - Integer.parseInt(command[1]);
                currentString.delete(startIndex, currentString.length());
                lastCommands.push(currentString.toString());
            }else if (command[0].equals("3")){
                int index = Integer.parseInt(command[1]) - 1;
                System.out.println(currentString.charAt(index));
            }else if (command[0].equals("4")){
                lastCommands.pop();
                String newString = lastCommands.peek();
                currentString.delete(0, currentString.length());
                currentString.append(newString);
            }
        }
    }
}
