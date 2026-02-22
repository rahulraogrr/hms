package com.hotel.exceptions;

import com.hotel.exceptions.models.InternalServerError;
import com.hotel.exceptions.models.messages.InternalServerMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Global Exception Handler
 * @author rgonda
 */
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = { ResourceNotFoundException.class })
    public ResponseEntity<ApiErrorResponse> handleNotFound(ResourceNotFoundException e) {
        log.warn("Resource not found: {}", e.getMessage());

        InternalServerError error = new InternalServerError();
        error.setTimestamp(LocalDateTime.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessages(List.of(InternalServerMessage.builder()
                .defaultMessage(e.getMessage()).build()));

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = { IllegalArgumentException.class })
    public ResponseEntity<ApiErrorResponse> handleBadRequest(IllegalArgumentException e) {
        log.warn("Bad request: {}", e.getMessage());

        InternalServerError error = new InternalServerError();
        error.setTimestamp(LocalDateTime.now());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessages(List.of(InternalServerMessage.builder()
                .defaultMessage(e.getMessage()).build()));

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<ApiErrorResponse> handleInternalServerError(Exception e){
        log.error("UNHANDLED EXCEPTION: ",e);

        InternalServerError error = new InternalServerError();
        error.setTimestamp(LocalDateTime.now());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMessages(List.of(InternalServerMessage.builder()
                .defaultMessage("An unexpected error occurred. Please try again later.").build()));

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
