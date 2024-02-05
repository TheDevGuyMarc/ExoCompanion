package de.traumastudios.ExoCompanionAPI.plant.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PlantNotFoundException extends RuntimeException {
    public PlantNotFoundException(String message) {
        super(message);
    }

    public PlantNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlantNotFoundException(Throwable cause) {
        super(cause);
    }

    public PlantNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
