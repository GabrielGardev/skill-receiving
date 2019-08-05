package softuni.bookshopsystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import softuni.bookshopsystem.entities.Author;
import softuni.bookshopsystem.repositories.AuthorRepository;
import softuni.bookshopsystem.services.AuthorService;
import softuni.bookshopsystem.utils.FileUtil;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    //Dont forgot to change the @PATH when you test
    private static final String AUTHORS_PATH = "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
            "05. Spring Data Intro\\02. Spring Data Intro - Exercise\\P01_Bookshop_System\\src\\main\\resources\\files\\authors.txt";

    private final AuthorRepository authorRepository;
    private final FileUtil fileUtil;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
    }


    @Override
    public void seedAuthors() throws IOException {
        if (authorRepository.count() > 0){
            return;
        }

        for (String[] names : fileUtil.fileContent(AUTHORS_PATH)) {
            Author author = new Author();
            author.setFirstName(names[0]);
            author.setLastName(names[1]);
            authorRepository.saveAndFlush(author);
        }
    }

    @Override
    public List<String> findAuthorsByNumberOfBooks() {
        List<Author> authors = this.authorRepository.findAllByOrderByBooksCountDesc();

        return authors
                .stream()
                .map(a -> String.format("%s %s - %s",
                        a.getFirstName(),
                        a.getLastName(),
                        a.getBooks().size()))
                .collect(Collectors.toList());
    }
}
