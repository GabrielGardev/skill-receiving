package bookshopsystemapp.service;

import bookshopsystemapp.domain.entities.EditionType;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface BookService {

    void seedBooks() throws IOException;

    List<String> getAllBooksTitlesAfter();

    Set<String> getAllAuthorsWithBookBefore();

    List<String> getBookTitlesByAgeRestriction(String restriction);

    List<String> getTitlesOfGoldenEditions();

    List<String> getTitlesAndPriceOfBooksWithPriceLessAndHigherThen();

    List<String> getTitlesOfBooksNotReleaseInGivenYear(int year);

    List<String> findAllByReleaseDateBefore(String date);

    List<String> findAllByTitleContaining(String letters);

    List<String> findBooksWhereLastNameOfAuthorStartsWith(String letters);

    String findAllByTitleIsGreaterThan(int count);

    List<String> findAllCopiesOfTheAuthor();

    String findByTitle(String title);

    long findAllByReleaseDateAfter(LocalDate date, int multiplier);

    int deleteBooksWithCopiesUnderGiven(int numberOfCopies);

    Integer getCountOfAuthorsBooks(String firstName, String lastName);
}
