import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P2_Song_Encryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            String line = scanner.nextLine();
            if (line.equals("end")){
                break;
            }
            StringBuilder sb = new StringBuilder();

            String artistAndSong[] = line.split(":");
            String artist = artistAndSong[0];
            String song = artistAndSong[1];

            Pattern patternArtist = Pattern.compile("^[A-Z][a-z' ]+$");
            Pattern patternSong = Pattern.compile("^[A-Z ]*$");

            Matcher matcherArtist = patternArtist.matcher(artist);
            Matcher matcherSong = patternSong.matcher(song);

            if (matcherArtist.find() && matcherSong.find()){
                int key = artist.length();
                song = song.trim();

                for (int i = 0; i < artist.length(); i++) {
                    char currentChar = artist.charAt(i);
                    int diff = 0;

                    if (currentChar == ' ' || currentChar == '\''){
                        sb.append(currentChar);
                    }else {
                        if (i == 0 && currentChar + key > 'Z'){
                            diff = key - (90 - currentChar);
                            char newChar = (char) (64 + diff);
                            sb.append(newChar);
                        } else if (currentChar + key > 122){
                            diff = key - (122 - currentChar);
                            char newChar = (char)(96 + diff);
                            sb.append(newChar);
                        }else {
                            char newChar = (char)(currentChar + key);
                            sb.append(newChar);
                        }
                    }
                }
                sb.append("@");
                for (int i = 0; i < song.length(); i++) {
                    char currentChar = song.charAt(i);
                    int diff = 0;

                    if (currentChar == ' ' || currentChar == '\''){
                        sb.append(currentChar);
                    }else {
                        if (currentChar + key > 90){
                            diff = key - (90 - currentChar);
                            char newChar = (char)(64 + diff);
                            sb.append(newChar);
                        }else {
                            char newChar = (char)(currentChar + key);
                            sb.append(newChar);
                        }
                    }
                }
                System.out.println(String.format("Successful encryption: %s", sb.toString()));
            }else {
                System.out.println("Invalid input!");
            }
        }
    }
}
