package com.example.viewbooksservice.listeners;

import com.example.viewbooksservice.ViewBooksServiceApplication;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.listener.RetryListenerSupport;

@Slf4j
public class DefaultListener extends RetryListenerSupport {


    @Override
    public <T, E extends Throwable> void close(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
        System.out.println("closed connection");
        log.info("closed connection");
        super.close(context, callback, throwable);

    }

    @Override
    public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
        System.out.println("drop error");
        log.error("drop error");
        super.onError(context, callback, throwable);

    }

    @Override
    public <T, E extends Throwable> boolean open(RetryContext context, RetryCallback<T, E> callback) {
        System.out.println("open connection");
        log.info("open connection");
        return super.open(context, callback);

    }
}
