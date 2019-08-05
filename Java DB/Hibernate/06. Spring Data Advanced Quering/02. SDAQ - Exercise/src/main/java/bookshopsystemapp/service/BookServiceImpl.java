package bookshopsystemapp.service;

import bookshopsystemapp.domain.entities.*;
import bookshopsystemapp.repository.AuthorRepository;
import bookshopsystemapp.repository.BookRepository;
import bookshopsystemapp.repository.CategoryRepository;
import bookshopsystemapp.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final static String BOOKS_FILE_PATH = "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
            "06. Spring Data Advanced Quering\\02. SDAQ - Exercise\\src\\main\\resources\\files\\books.txt";

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedBooks() throws IOException {
        if (this.bookRepository.count() != 0) {
            return;
        }

        String[] booksFileContent = this.fileUtil.getFileContent(BOOKS_FILE_PATH);
        for (String line : booksFileContent) {
            String[] lineParams = line.split("\\s+");

            Book book = new Book();
            book.setAuthor(this.getRandomAuthor());

            EditionType editionType = EditionType.values()[Integer.parseInt(lineParams[0])];
            book.setEditionType(editionType);

            LocalDate releaseDate = LocalDate.parse(lineParams[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
            book.setReleaseDate(releaseDate);

            int copies = Integer.parseInt(lineParams[2]);
            book.setCopies(copies);

            BigDecimal price = new BigDecimal(lineParams[3]);
            book.setPrice(price);

            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(lineParams[4])];
            book.setAgeRestriction(ageRestriction);

            StringBuilder title = new StringBuilder();
            for (int i = 5; i < lineParams.length; i++) {
                title.append(lineParams[i]).append(" ");
            }

            book.setTitle(title.toString().trim());

            Set<Category> categories = this.getRandomCategories();
            book.setCategories(categories);

            this.bookRepository.saveAndFlush(book);
        }
    }

    @Override
    public List<String> getAllBooksTitlesAfter() {
        List<Book> books = this.bookRepository.findAllByReleaseDateAfter(LocalDate.parse("2000-12-31"));

        return books.stream().map(b -> b.getTitle()).collect(Collectors.toList());
    }

    @Override
    public Set<String> getAllAuthorsWithBookBefore() {
        List<Book> books = this.bookRepository.findAllByReleaseDateBefore(LocalDate.parse("1990-01-01"));

        return books.stream().map(b -> String.format("%s %s", b.getAuthor().getFirstName(), b.getAuthor().getLastName())).collect(Collectors.toSet());
    }

    private Author getRandomAuthor() {
        Random random = new Random();

        int randomId = random.nextInt((int) (this.authorRepository.count() - 1)) + 1;

        return this.authorRepository.findById(randomId).orElse(null);
    }

    private Set<Category> getRandomCategories() {
        Set<Category> categories = new LinkedHashSet<>();

        Random random = new Random();
        int length = random.nextInt(5);

        for (int i = 0; i < length; i++) {
            Category category = this.getRandomCategory();

            categories.add(category);
        }

        return categories;
    }

    private Category getRandomCategory() {
        Random random = new Random();

        int randomId = random.nextInt((int) (this.categoryRepository.count() - 1)) + 1;

        return this.categoryRepository.findById(randomId).orElse(null);
    }

    @Override
    public List<String> getBookTitlesByAgeRestriction(String restriction) {
        restriction = restriction.toUpperCase();
        return this.bookRepository.findAllByAgeRestriction(AgeRestriction.valueOf(restriction))
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getTitlesOfGoldenEditions() {
        EditionType editionType = EditionType.GOLD;
        int copies = 5000;
        return this.bookRepository.findAllByEditionTypeAndCopiesLessThan(editionType, copies)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getTitlesAndPriceOfBooksWithPriceLessAndHigherThen() {
        BigDecimal less = BigDecimal.valueOf(5);
        BigDecimal great = BigDecimal.valueOf(40);

        return this.bookRepository.findAllByPriceLessThanOrPriceGreaterThan(less, great)
                .stream()
                .map(b -> String.format("%s - $%.2f",
                        b.getTitle(),
                        b.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getTitlesOfBooksNotReleaseInGivenYear(int year) {
        LocalDate before = LocalDate.of(year, 1, 1);
        LocalDate after = LocalDate.of(year, 12, 31);
        return this.bookRepository.findAllByReleaseDateBeforeOrReleaseDateAfter(before,after)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllByReleaseDateBefore(String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return this.bookRepository.findAllByReleaseDateBefore(localDate)
                .stream()
                .map(b -> String.format("%s %s %.2f",
                        b.getTitle(),
                        b.getEditionType(),
                        b.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllByTitleContaining(String letters) {
        return this.bookRepository.findAllByTitleContainingLetters(letters.toLowerCase())
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findBooksWhereLastNameOfAuthorStartsWith(String letters) {
        return this.bookRepository.findBooksWhereLastNameOfAuthorStartsWith(letters.toLowerCase())
                .stream()
                .map(b -> String.format("%s (%s %s)",
                        b.getTitle(),
                        b.getAuthor().getFirstName(),
                        b.getAuthor().getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public String  findAllByTitleIsGreaterThan(int count) {
        List<Book> list = this.bookRepository.findAllByTitleIsGreaterThan(count);

        return String.format("%d Comment: There are %d books with longer title than %d symbols",
                list.size(),
                list.size(),
                count);
    }

    @Override
    public List<String> findAllCopiesOfTheAuthor() {
        return this.bookRepository.findAllCopiesOfTheAuthor()
                .stream()
                .map(v -> String.format("%s %s - %s",
                        v[0],
                        v[1],
                        v[2]))
                .collect(Collectors.toList());
    }

    @Override
    public String findByTitle(String title) {
        ReduceBook reduceBook = this.bookRepository.findAllByTitle(title);
        return String.format("%s %s %s %.2f",
                reduceBook.getTitle(),
                reduceBook.getEditionType().toString(),
                reduceBook.getAgeRestriction().toString(),
                reduceBook.getPrice());
    }

    @Override
    public long findAllByReleaseDateAfter(LocalDate date, int forAdding) {
        List<Book> list = this.bookRepository.findAllByReleaseDateAfter(date);

        for (Book book : list) {
            book.setCopies(book.getCopies() + forAdding);
            this.bookRepository.saveAndFlush(book);
        }


        return list.size() * forAdding;
    }

    @Override
    public int deleteBooksWithCopiesUnderGiven(int numberOfCopies) {
        List<Book> list = this.bookRepository.findAllByCopiesLessThan(numberOfCopies);

        this.bookRepository.deleteInBatch(list);
        return list.size();
    }

    @Override
    public Integer getCountOfAuthorsBooks(String firstName, String lastName) {
        return this.bookRepository.getCountOfAuthorsBooks(firstName, lastName);
    }
}
