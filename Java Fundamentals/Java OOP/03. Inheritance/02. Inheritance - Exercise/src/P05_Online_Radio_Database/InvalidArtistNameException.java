package P05_Online_Radio_Database;

public class InvalidArtistNameException extends InvalidSongException {

    public InvalidArtistNameException(String message) {
        super(message);
    }
}
