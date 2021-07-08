package com.egen.texashamburger.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceException extends RuntimeException{
    public static final long serialVersionUID = 1L;
    public OrderServiceException(String message) {
        super(message);
    }
    public OrderServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
