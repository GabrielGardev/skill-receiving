import java.util.Scanner;

public class P7_String_Explosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] line = scanner.nextLine().toCharArray();
        StringBuilder sb = new StringBuilder();

        int power = 0;
        int reminder = 0;
        for (int i = 0; i < line.length; i++) {
            char currentChar = line[i];
            if (currentChar == '>'){
                power = Integer.parseInt(line[i + 1] + "") + reminder;
                reminder = 0;
                sb.append(currentChar);
                for (int j = i + 1; j < i + 1 + power; j++) {
                    try {
                        if (line[j] != '>'){
                            i++;
                            power--;
                        }else {
                            reminder = power;
                            break;
                        }
                    }catch (Exception e){
                        System.out.println(sb.toString());
                        return;
                    }
                }
            }else {
                sb.append(currentChar);
            }
        }
        System.out.println(sb.toString());
    }
}
