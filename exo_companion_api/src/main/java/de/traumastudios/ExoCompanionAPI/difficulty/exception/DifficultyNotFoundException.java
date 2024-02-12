package de.traumastudios.ExoCompanionAPI.difficulty.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DifficultyNotFoundException extends RuntimeException {
    public DifficultyNotFoundException(String message) {
        super(message);
    }

    public DifficultyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DifficultyNotFoundException(Throwable cause) {
        super(cause);
    }

    public DifficultyNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
