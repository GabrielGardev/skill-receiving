package softuni.bookshopsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.bookshopsystem.entities.Author;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Author findAuthorByFirstNameAndLastName(String firstName, String lastName);

    @Query(value = "SELECT a FROM Author a WHERE a.books.size > 0 order by a.books.size DESC")
    List<Author> findAllByOrderByBooksCountDesc();
}
