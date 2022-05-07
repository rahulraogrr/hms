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

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<ApiErrorResponse> handleInternalServerError(Exception e){
        log.error("UNHANDLED EXCEPTION: ",e);

        InternalServerError error = new InternalServerError();
        error.setTimestamp(LocalDateTime.now());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMessages(List.of(InternalServerMessage.builder()
                .defaultMessage("").build()));

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
