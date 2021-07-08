package com.egen.texashamburger.exception.handler;

import com.egen.texashamburger.exception.*;
import com.egen.texashamburger.response.Response;
import com.egen.texashamburger.response.ResponseMetadata;
import com.egen.texashamburger.response.StatusMessage;
import com.egen.texashamburger.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MenuServiceException.class)
    public ResponseEntity<Object> handleMenuServiceException(MenuServiceException e) {
        ExceptionMessage exceptionMessage = new ExceptionMessage(
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                LocalDateTime.now()
        );
        log.error(e.getMessage());
        return new ResponseEntity<>(exceptionMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(LocationServiceException.class)
    public ResponseEntity<Object> handleLocationServiceException(LocationServiceException e) {
        ExceptionMessage exceptionMessage = new ExceptionMessage(
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                LocalDateTime.now()
        );
        log.error(e.getMessage());
        return new ResponseEntity<>(exceptionMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(OrderServiceException.class)
    public ResponseEntity<Object> handleOrderServiceException(OrderServiceException e) {
        ExceptionMessage exceptionMessage = new ExceptionMessage(
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                LocalDateTime.now()
        );
        log.error(e.getMessage());
        return new ResponseEntity<>(exceptionMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RestaurantServiceException.class)
    public ResponseEntity<Object> handleRestaurantServiceException(RestaurantServiceException e) {
        ExceptionMessage exceptionMessage = new ExceptionMessage(
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                LocalDateTime.now()
        );
        log.error(e.getMessage());
        return new ResponseEntity<>(exceptionMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InterceptorServiceException.class)
    public ResponseEntity<Object> handleInterceptorServiceException(InterceptorServiceException e) {
        ExceptionMessage exceptionMessage = new ExceptionMessage(
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                LocalDateTime.now()
        );
        log.error(e.getMessage());
        return new ResponseEntity<>(exceptionMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
