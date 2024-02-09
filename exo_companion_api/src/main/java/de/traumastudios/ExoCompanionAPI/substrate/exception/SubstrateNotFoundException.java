package de.traumastudios.ExoCompanionAPI.substrate.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SubstrateNotFoundException extends RuntimeException {
    public SubstrateNotFoundException(String message) {
        super(message);
    }

    public SubstrateNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SubstrateNotFoundException(Throwable cause) {
        super(cause);
    }

    public SubstrateNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
