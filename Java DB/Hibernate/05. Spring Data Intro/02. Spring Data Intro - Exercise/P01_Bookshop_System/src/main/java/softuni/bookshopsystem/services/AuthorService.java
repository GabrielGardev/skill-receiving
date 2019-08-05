package softuni.bookshopsystem.services;

import softuni.bookshopsystem.entities.Author;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    List<String> findAuthorsByNumberOfBooks();
}
