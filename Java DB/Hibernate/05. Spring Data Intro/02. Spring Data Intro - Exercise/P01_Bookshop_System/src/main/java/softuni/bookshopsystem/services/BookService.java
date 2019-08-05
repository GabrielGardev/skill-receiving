package softuni.bookshopsystem.services;

import softuni.bookshopsystem.entities.Author;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;
    List<String> findAllTitlesAfterGivenDate(String date);
    List<String> findAllAuthorsNamesWithBooksBeforeGivenDate(String date);
    List<String> findAllBooksOfGivenAuthor();
}
