package P05_Online_Radio_Database;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Song {
    private String artistName;
    private String songName;
    private String length;

    public Song(String artistName, String songName, String length) throws InvalidSongException {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setLength(length);
    }

    private void setArtistName(String artistName) throws InvalidArtistNameException {
        if (artistName.length() < 3 || artistName.length() > 20){
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }
        this.artistName = artistName;
    }

    private void setSongName(String songName) throws InvalidSongNameException {
        if (songName.length() < 3 || songName.length() > 30){
            throw new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
        }
        this.songName = songName;
    }

    private void setLength(String length) throws InvalidSongLengthException {
        String[] time = length.split(":");
        int min = Integer.parseInt(time[0]);
        int sec = Integer.parseInt(time[1]);

        if ((min / 60 + sec) > 899 || (min / 60 + sec) < 0){
            throw new InvalidSongLengthException("Invalid song length.");
        }

        if (min > 14 || min < 0){
            throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
        }
        if (sec > 59 || sec < 0){
            throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
        }
        this.length = length;
    }

    protected String getLength() {
        return length;
    }
}
