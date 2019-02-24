package P01_Book;

import jdk.dynalink.linker.LinkerServices;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Aleko", 1670, "Penio", "Pesho", "Gosho");

        List<Book> books = new ArrayList<>();
        books.add(bookOne);
    }
}
