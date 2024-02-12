package de.traumastudios.ExoCompanionAPI.behavior.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BehaviorNotFoundException extends RuntimeException {
    public BehaviorNotFoundException(String message) {
        super(message);
    }

    public BehaviorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BehaviorNotFoundException(Throwable cause) {
        super(cause);
    }

    public BehaviorNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
