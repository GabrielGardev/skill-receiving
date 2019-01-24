import java.util.Scanner;

public class P6_Replace_Repeating_Chars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        StringBuilder sb = new StringBuilder();


        int j=0;
        char arr[]=new char[50];
        for (int i = 0; i < line.length() - 1; i++) {
            if(line.charAt(i)!=line.charAt(i+1)){
                arr[j]=line.charAt(i);
                j++;
            }
        }
        arr[j]=line.charAt(line.length()-1);
        for(char c:arr){
            sb.append(c);
        }

        System.out.println(sb.toString());
    }
}
