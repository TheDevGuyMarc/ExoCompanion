package de.traumastudios.ExoCompanionAPI.landanimal.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LandAnimalNotFoundException extends RuntimeException {
    public LandAnimalNotFoundException(String message) {
        super(message);
    }

    public LandAnimalNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public LandAnimalNotFoundException(Throwable cause) {
        super(cause);
    }

    public LandAnimalNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
