package softuni.bookshopsystem.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.bookshopsystem.entities.Author;
import softuni.bookshopsystem.entities.Book;
import softuni.bookshopsystem.entities.Category;
import softuni.bookshopsystem.entities.enums.AgeRestriction;
import softuni.bookshopsystem.entities.enums.EditionType;
import softuni.bookshopsystem.repositories.AuthorRepository;
import softuni.bookshopsystem.repositories.BookRepository;
import softuni.bookshopsystem.repositories.CategoryRepository;
import softuni.bookshopsystem.services.BookService;
import softuni.bookshopsystem.utils.FileUtil;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    //Dont forgot to change the @PATH when you test
    private static final String BOOKS_PATH = "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
            "05. Spring Data Intro\\02. Spring Data Intro - Exercise\\P01_Bookshop_System\\src\\main\\resources\\files\\books.txt";

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
        if (this.bookRepository.count() > 0){
            return;
        }

        for (String[] data : fileUtil.fileContent(BOOKS_PATH)) {
            Book book = new Book();
            Author author = randomAuthor();
            book.setAuthor(author);

            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            book.setEditionType(editionType);

            LocalDate date = LocalDate.parse(data[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
            book.setReleaseDate(date);

            book.setCopies(Integer.parseInt(data[2]));

            BigDecimal price = new BigDecimal(data[3]);
            book.setPrice(price);

            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
            book.setAgeRestriction(ageRestriction);

            book.setTitle(getTitle(data));

            Set<Category> categories = randomCategories();
            book.setCategories(categories);
            this.bookRepository.saveAndFlush(book);
        }
    }

    @Override
    public List<String> findAllTitlesAfterGivenDate(String date) {
        LocalDate formattedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("d/M/yyyy"));

        return this.bookRepository.findAllByReleaseDateAfter(formattedDate).stream()
                .map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<String> findAllAuthorsNamesWithBooksBeforeGivenDate(String date) {
        LocalDate formattedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("d/M/yyyy"));

        return this.bookRepository.findAllByReleaseDateBefore(formattedDate)
                .stream()
                .map(b -> String.format("%s %s", b.getAuthor().getFirstName(),
                        b.getAuthor().getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksOfGivenAuthor() {
        Author author = this.authorRepository.findAuthorByFirstNameAndLastName("George", "Powell");

        return bookRepository.findAllByAuthorOrderByReleaseDateDescTitleAsc(author)
                .stream()
                .map(b -> String.format("%s - %s - %d",
                        b.getTitle(),
                        b.getReleaseDate().toString(),
                        b.getCopies()))
                .collect(Collectors.toList());
    }

    private String getTitle(String[] data) {
        StringBuilder titleBuilder = new StringBuilder();
        for (int i = 5; i <= data.length - 1; i++) {
            titleBuilder.append(data[i]).append(" ");
        }
        return titleBuilder.toString().trim();
    }

    private Author randomAuthor() {
        Random random = new Random();

        int id = random.nextInt((int) this.authorRepository.count()) + 1;

        return this.authorRepository.getOne(id);
    }

    private Category randomCategory() {
        Random random = new Random();

        int id = random.nextInt((int) this.categoryRepository.count()) + 1;

        return this.categoryRepository.getOne(id);
    }

    private Set<Category> randomCategories(){
        Set<Category> categories = new LinkedHashSet<>();

        Random random = new Random();
        int index = random.nextInt((int) this.categoryRepository.count()) + 1;

        for (int i = 0; i < index; i++) {
            categories.add(randomCategory());
        }
        return categories;
    }
}
