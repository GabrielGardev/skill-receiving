package softuni.bookshopsystem.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import softuni.bookshopsystem.services.AuthorService;
import softuni.bookshopsystem.services.BookService;
import softuni.bookshopsystem.services.CategoryService;

@Controller
public class AppController implements CommandLineRunner {
    private AuthorService authorService;
    private CategoryService categoryService;
    private BookService bookService;

    @Autowired
    public AppController(AuthorService authorService, CategoryService categoryService, BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.authorService.seedAuthors();
        this.categoryService.seedCategories();
        this.bookService.seedBooks();

//        //1.Get all books after the year 2000. Print only their titles.
//        for (String s : this.bookService.findAllTitlesAfterGivenDate("31/12/2000")) {
//            System.out.println(s);
//        }

//        //2.Get all authors with at least one book with release date before 1990.
//        Print their first name and last name.
//        for (String s : this.bookService.findAllAuthorsNamesWithBooksBeforeGivenDate("01/01/1990")) {
//            System.out.println(s);
//        }

//        //3.Get all authors, ordered by the number of their books (descending).
//        // Print their first name, last name and book count.
//        for (String author : this.authorService.findAuthorsByNumberOfBooks()) {
//            System.out.println(author);
//        }

//         //4.Get all books from author George Powell, ordered by their release date (descending),
//         //then by book title (ascending). Print the book's title, release date and copies.
//        for (String item : this.bookService.findAllBooksOfGivenAuthor()) {
//            System.out.println(item);
//        }

    }
}
