package com.egen.texashamburger.exception.handler;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExceptionMessage {
    private String message;
    private HttpStatus httpStatus;
    private LocalDateTime timestamp;

    public ExceptionMessage(String message, HttpStatus httpStatus, LocalDateTime timestamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }
}
