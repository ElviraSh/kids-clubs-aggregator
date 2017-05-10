package ru.dmilut.prodlenka.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

/**
 * Created by parents on 09.05.2017.
 */
@ControllerAdvice
public class GlobalHandlerException {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(GlobalHandlerException.class);

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "IOException occured")
    @ExceptionHandler(IOException.class)
    public void handleIOException() {
        logger.error("IOException handler executed");
    }
}