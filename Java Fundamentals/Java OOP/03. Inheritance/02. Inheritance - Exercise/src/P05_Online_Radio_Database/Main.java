package P05_Online_Radio_Database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        SongDatabase songDatabase = new SongDatabase();

        for (int i = 0; i < n; i++) {
            String [] line = reader.readLine().split(";");

            try {
                Song song = new Song(line[0], line[1], line[2]);
                songDatabase.addSong(song);
                System.out.println("Song added.");
            }catch (InvalidSongException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println(songDatabase.toString());
    }
}
