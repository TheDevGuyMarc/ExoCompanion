package de.traumastudios.ExoCompanionAPI.planttype.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PlantTypeNotFoundException extends RuntimeException {
    public PlantTypeNotFoundException(String message) {
        super(message);
    }

    public PlantTypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlantTypeNotFoundException(Throwable cause) {
        super(cause);
    }

    public PlantTypeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
