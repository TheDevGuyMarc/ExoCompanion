package de.traumastudios.ExoCompanionAPI.food.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FoodNotFoundException extends RuntimeException {
    public FoodNotFoundException(String message) {
        super(message);
    }

    public FoodNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FoodNotFoundException(Throwable cause) {
        super(cause);
    }

    public FoodNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
