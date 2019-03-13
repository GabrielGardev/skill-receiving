package P05_Online_Radio_Database;

public class InvalidSongException extends IllegalArgumentException {
    private String message;

    InvalidSongException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
