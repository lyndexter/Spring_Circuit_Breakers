package com.example.viewbooksservice;

import com.example.viewbooksservice.models.Book;
import io.github.resilience4j.retry.RetryRegistry;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class BookService {


    public BookService(RetryRegistry retryRegistry) {
        retryRegistry.getAllRetries().forEach(retry -> retry.getEventPublisher().onEvent(event -> log.info(event.toString())));
    }

    private final RestTemplate restTemplate = new RestTemplate();

    //    @Retryable(value = RuntimeException.class, maxAttempts = 2, backoff = @Backoff(delay = 100))
    @Retry(name = "get", fallbackMethod = "recover")
    public List<Book> getBooks() {
        String url = "http://localhost:8081/book_shop/book";
        Book[] books = restTemplate.getForObject(url, Book[].class);

        return Arrays.asList(books);
    }

    //    @Recover
    public List<Book> recover(RuntimeException e) {
        System.out.println(e.getMessage());
        log.error(e.getMessage());
        return new ArrayList<>(Arrays.asList(
                new Book(1, "stt", 2014, 344), new Book(2, "stt", 2014, 344)));
    }

}
