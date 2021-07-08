package com.egen.texashamburger.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MenuServiceException extends  RuntimeException {
    public static final long serialVersionUID = 1L;

    public MenuServiceException(String message) {
        super(message);
    }
    public MenuServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
