import java.util.Scanner;

public class P3_Extract_File {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

            String[] line = input.split("\\\\");

                int index = line[line.length - 1].lastIndexOf(".");

                String file = line[line.length - 1].substring(0, index);
                String extension = line[line.length - 1].substring(index + 1);


                System.out.println(String.format("File name: %s", file));
                System.out.println(String.format("File extension: %s", extension));


    }
}
