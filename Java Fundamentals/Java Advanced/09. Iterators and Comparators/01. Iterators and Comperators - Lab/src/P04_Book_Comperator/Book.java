package P04_Book_Comperator;

import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book>{
    private String title;

    private int year;

    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private void setAuthors(String... values) {
        this.authors = Arrays.asList(values);
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    @Override
    public int compareTo(Book o) {
        int result = this.title.compareTo(o.getTitle());

        if (result == 0){

            result = Integer.compare(this.year,o.getYear());
        }

        return result;
    }
}
