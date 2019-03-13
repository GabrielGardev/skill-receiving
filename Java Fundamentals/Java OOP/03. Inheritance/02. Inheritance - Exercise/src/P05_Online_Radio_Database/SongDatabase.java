package P05_Online_Radio_Database;

import java.util.ArrayList;
import java.util.List;

public class SongDatabase {
    private List<Song> songs;

    public SongDatabase() {
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song){
        this.songs.add(song);
    }

    public String getTotalLengthOfSongs(){
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        for (Song song : songs) {
            int min = Integer.parseInt(song.getLength().split(":")[0]);
            int sec = Integer.parseInt(song.getLength().split(":")[1]);

            minutes += min;
            seconds += sec;

            if (seconds > 59){
                minutes++;
                seconds -= 60;
            }

            if (minutes > 59){
                hours++;
                minutes -= 60;
            }
        }
        return String.format("%dh %dm %ds", hours, minutes, seconds);
    }

    @Override
    public String toString() {
        return String.format("Songs added: %d%nPlaylist length: %s", this.songs.size(), this.getTotalLengthOfSongs());
    }
}
