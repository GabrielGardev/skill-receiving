import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P3_Songs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Songs> songs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String [] line = scanner.nextLine().split("_");

            Songs songs1 = new Songs(line[0], line[1], line[2]);
            songs.add(songs1);
        }
        String cmd = scanner.nextLine();
        if (cmd.equals("all")){
            songs.forEach(x -> System.out.println(x.name));
        }else {
            songs.stream().filter(s -> s.typeList.equals(cmd)).forEach(x -> System.out.println(x.name));
        }

    }
    public static class Songs {
        private String typeList;
        private String name;
        private String time;

        public Songs(String typeList, String name, String time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }
    }
}
