package softuni.bookshopsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bookshopsystem.entities.Author;
import softuni.bookshopsystem.entities.Book;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByReleaseDateAfter(LocalDate date);
    List<Book> findAllByReleaseDateBefore(LocalDate date);
    List<Book> findAllByAuthorOrderByReleaseDateDescTitleAsc(Author author);
}
