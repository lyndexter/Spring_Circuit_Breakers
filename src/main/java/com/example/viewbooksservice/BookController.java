package com.example.viewbooksservice;

import com.example.viewbooksservice.models.Book;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@PropertySource("classpath:retryConfig.properties")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }


    @CircuitBreaker(name = "example", fallbackMethod = "fallback")
    @GetMapping(value = "/api/delay/{delay}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> delay(@PathVariable int delay) throws InterruptedException {
        Thread.sleep(delay * 1000L);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Boolean> fallback(Exception e) throws InterruptedException {
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
