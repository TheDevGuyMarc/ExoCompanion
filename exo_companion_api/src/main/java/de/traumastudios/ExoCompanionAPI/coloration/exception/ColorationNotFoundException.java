package de.traumastudios.ExoCompanionAPI.coloration.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ColorationNotFoundException extends RuntimeException {
    public ColorationNotFoundException(String message) {
        super(message);
    }

    public ColorationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ColorationNotFoundException(Throwable cause) {
        super(cause);
    }

    public ColorationNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
