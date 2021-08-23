package com.example.viewbooksservice;

import com.example.viewbooksservice.models.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {AppConfig.class, BookService.class},
        loader = AnnotationConfigContextLoader.class)
public class SpringRetryIntegrationTest {
    @Autowired
    private BookService bookService;

    @Autowired
    private RetryTemplate retryTemplate;

    @Test
    public void givenTemplateRetryService_whenCallWithException_thenRetry() {
        retryTemplate.execute(arg0 -> {
            List<Book> books = bookService.getBooks();
            assertEquals(new ArrayList<>(Arrays.asList(
                    new Book(1, "stt", 2014, 344), new Book(2, "stt", 2014, 344))), books);
            return null;
        });

    }
}
