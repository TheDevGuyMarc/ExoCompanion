package de.traumastudios.ExoCompanionAPI.aquaticanimal.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AquaticAnimalNotFoundException extends RuntimeException {
    public AquaticAnimalNotFoundException(String message) {
        super(message);
    }

    public AquaticAnimalNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AquaticAnimalNotFoundException(Throwable cause) {
        super(cause);
    }

    public AquaticAnimalNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
