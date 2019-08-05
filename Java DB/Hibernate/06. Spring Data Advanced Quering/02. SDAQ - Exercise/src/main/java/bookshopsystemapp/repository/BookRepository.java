package bookshopsystemapp.repository;

import bookshopsystemapp.domain.entities.AgeRestriction;
import bookshopsystemapp.domain.entities.Book;
import bookshopsystemapp.domain.entities.EditionType;
import bookshopsystemapp.domain.entities.ReduceBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAllByReleaseDateAfter(LocalDate date);

    List<Book> findAllByReleaseDateBefore(LocalDate date);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal less, BigDecimal greater);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate before, LocalDate after);

    @Query("SELECT b from Book as b where lower(b.title) like %:letters%")
    List<Book> findAllByTitleContainingLetters(@Param(value = "letters") String letters);

    @Query("select b from Book b inner join b.author as a where lower(a.lastName) like :letters%")
    List<Book> findBooksWhereLastNameOfAuthorStartsWith(@Param(value = "letters") String letters);

    @Query("select b from Book b where length(b.title) > :count")
    List<Book> findAllByTitleIsGreaterThan(@Param(value = "count") int count);

    @Query("select a.firstName, a.lastName, sum(b.copies) as total from Book b " +
            "inner join b.author as a " +
            "group by b.author " +
            "order by total desc")
    List<Object[]> findAllCopiesOfTheAuthor();

    ReduceBook findAllByTitle(String title);

    List<Book> findAllByCopiesLessThan(int copies);

    @Query(value = "{call usp_get_count_of_books_by_author(:init_first_name, :init_last_name)}", nativeQuery = true)
    Integer getCountOfAuthorsBooks(@Param("init_first_name") String init_first_name,
                               @Param("init_last_name") String init_last_name);
}
