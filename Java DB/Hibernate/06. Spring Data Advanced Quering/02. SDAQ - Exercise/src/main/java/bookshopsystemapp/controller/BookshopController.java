package bookshopsystemapp.controller;

import bookshopsystemapp.service.AuthorService;
import bookshopsystemapp.service.BookService;
import bookshopsystemapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class BookshopController implements CommandLineRunner {

    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;
    private BufferedReader reader;

    @Autowired
    public BookshopController(AuthorService authorService, CategoryService categoryService, BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... strings) throws Exception {
        this.authorService.seedAuthors();
        this.categoryService.seedCategories();
        this.bookService.seedBooks();

        pseudoEngine();
    }

    private void pseudoEngine() throws IOException {
        System.out.println("Please enter task number: ");
        int taskNum = Integer.parseInt(reader.readLine());
        switch (taskNum) {
            case 1:
                this.task1();
                break;
            case 2:
                this.task2();
                break;
            case 3:
                this.task3();
                break;
            case 4:
                this.task4();
                break;
            case 5:
                this.task5();
                break;
            case 6:
                this.task6();
                break;
            case 7:
                this.task7();
                break;
            case 8:
                //dont forget about random authors insertion
                this.task8();
                break;
            case 9:
                //174 is the right answer not 171
                this.task9();
                break;
            case 10:
                //results is different because random seed of authors
                this.task10();
                break;
            case 11:
                this.task11();
                break;
            case 12:
                this.task12();
                break;
            case 13:
                this.task13();
                break;
            case 14:
                this.task14();
                break;
        }
    }

    private void task14() throws IOException {
        String firstName = reader.readLine();
        String lastName = reader.readLine();
        int countOfAuthorsBooks = this.bookService
                .getCountOfAuthorsBooks(firstName, lastName);
        System.out.println(countOfAuthorsBooks > 1
                ? String.format("%s %s has written %d books",
                    firstName,
                    lastName,
                    countOfAuthorsBooks)
                : String.format("%s %s has written %d book",
                    firstName,
                    lastName,
                    countOfAuthorsBooks));
    }

    private void task13() throws IOException {
        int numOfCopies = Integer.parseInt(reader.readLine());
        int i = this.bookService.deleteBooksWithCopiesUnderGiven(numOfCopies);
        System.out.println(i);
    }

    private void task12() throws IOException {
        String text = reader.readLine().replace(" ", "-");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        LocalDate date = LocalDate.parse(text, formatter);

        int multiplier = Integer.parseInt(reader.readLine());
        System.out.println(this.bookService.findAllByReleaseDateAfter(date, multiplier));
    }

    private void task11() throws IOException {
        String title = reader.readLine();
        System.out.println(this.bookService.findByTitle(title));
    }

    private void task10() {
        this.bookService.findAllCopiesOfTheAuthor()
                .forEach(System.out::println);
    }

    private void task9() throws IOException {
        int num = Integer.parseInt(reader.readLine());
        System.out.println(this.bookService.findAllByTitleIsGreaterThan(num));
    }

    private void task8() throws IOException {
        String letters = reader.readLine();
        this.bookService.findBooksWhereLastNameOfAuthorStartsWith(letters)
                .forEach(System.out::println);
    }

    private void task7() throws IOException {
        String letters = reader.readLine();
        this.bookService.findAllByTitleContaining(letters)
                .forEach(System.out::println);
    }

    private void task6() throws IOException {
        String letters = reader.readLine();
        this.authorService.findAllByFirstNameEndsWith(letters)
                .forEach(System.out::println);
    }

    private void task5() throws IOException {
        String date = reader.readLine();
        this.bookService.findAllByReleaseDateBefore(date)
                .forEach(System.out::println);
    }

    private void task4() throws IOException {
        int year = Integer.parseInt(reader.readLine());
        this.bookService.getTitlesOfBooksNotReleaseInGivenYear(year)
                .forEach(System.out::println);
    }

    private void task3() {
        this.bookService.getTitlesAndPriceOfBooksWithPriceLessAndHigherThen()
                .forEach(System.out::println);
    }

    private void task2() {
        this.bookService.getTitlesOfGoldenEditions()
                .forEach(System.out::println);
    }

    private void task1() throws IOException {
        String ageRestriction = reader.readLine();
        this.bookService.getBookTitlesByAgeRestriction(ageRestriction)
                .forEach(System.out::println);
    }
}
