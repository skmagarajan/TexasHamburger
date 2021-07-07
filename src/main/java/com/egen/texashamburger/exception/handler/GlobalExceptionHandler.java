package com.egen.texashamburger.exception.handler;

import com.egen.texashamburger.exception.MenuServiceException;
import com.egen.texashamburger.response.Response;
import com.egen.texashamburger.response.ResponseMetadata;
import com.egen.texashamburger.response.StatusMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(MenuServiceException.class)
    public ResponseEntity<Response<?>> handleEmployeesServiceException(MenuServiceException e) {
        log.error(e.getMessage());
        return buildResponse(StatusMessage.UNKNOWN_INTERNAL_ERROR, INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Response<?>> buildResponse(StatusMessage statusMessage, HttpStatus status) {
        var response = Response.builder()
                .meta(ResponseMetadata.builder()
                        .statusMessage(statusMessage.name())
                        .statusCode(status.value())
                        .build())
                .build();
        return ResponseEntity.status(status)
                .body(response);
    }
}