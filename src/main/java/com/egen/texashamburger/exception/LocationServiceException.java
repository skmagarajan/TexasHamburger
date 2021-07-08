package com.egen.texashamburger.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocationServiceException extends RuntimeException{
    public static final long serialVersionUID = 1L;
    public LocationServiceException(String message) {
        super(message);
    }
    public LocationServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
