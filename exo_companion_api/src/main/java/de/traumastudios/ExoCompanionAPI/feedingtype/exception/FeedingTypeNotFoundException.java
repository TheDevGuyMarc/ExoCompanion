package de.traumastudios.ExoCompanionAPI.feedingtype.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FeedingTypeNotFoundException extends RuntimeException {
    public FeedingTypeNotFoundException(String message) {
        super(message);
    }

    public FeedingTypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FeedingTypeNotFoundException(Throwable cause) {
        super(cause);
    }

    public FeedingTypeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
