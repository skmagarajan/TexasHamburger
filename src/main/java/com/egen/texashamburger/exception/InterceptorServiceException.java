package com.egen.texashamburger.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InterceptorServiceException extends RuntimeException {
    public static final long serialVersionUID = 1L;
    public InterceptorServiceException(String message) {
        super(message);
    }
    public InterceptorServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
