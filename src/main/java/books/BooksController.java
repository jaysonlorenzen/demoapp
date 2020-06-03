package books;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@RestController
public class BooksController {
    private static final Book[] books = {
            new Book(1L, "Book One", "Author One"),
            new Book(2L, "Book Two", "Author Two"),
            new Book(3L, "Book Three", "Author One")};

    @GetMapping("/books")
    public Book[] books(){
        return books;
    }


    @GetMapping("/books/id/{id}")
    public Book book(@PathVariable int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }

        throw new ResponseStatusException (
                HttpStatus.NOT_FOUND, "Entity not found"
        );
    }


    @GetMapping("/books/title/{name}")
    public Book book(@PathVariable String name) {
        for (Book book : books) {
            if (book.getName().equals(name)) {
                return book;
            }
        }

        throw new ResponseStatusException (
                HttpStatus.NOT_FOUND, "Entity not found"
        );
    }

}


