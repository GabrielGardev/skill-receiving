package P02_Library;

import java.util.ArrayList;
import java.util.Arrays;

public class Book {
    private String title;
    private int year;
    private ArrayList<String> authors;

    public Book(String title, int year,String... authors) {
        this.title = title;
        this.year = year;
        this.setAuthors(authors);
    }

    public void setAuthors(String... authors) {
        if (authors.length == 0){
            this.authors = new ArrayList<>();
        }else {
            this.authors = new ArrayList<>(Arrays.asList(authors));
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }
}
