package de.traumastudios.ExoCompanionAPI.rarity.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RarityNotFoundException extends RuntimeException {
    public RarityNotFoundException(String message) {
        super(message);
    }

    public RarityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RarityNotFoundException(Throwable cause) {
        super(cause);
    }

    public RarityNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
