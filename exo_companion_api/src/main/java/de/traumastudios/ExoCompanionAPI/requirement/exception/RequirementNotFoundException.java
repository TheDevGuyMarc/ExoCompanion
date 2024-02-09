package de.traumastudios.ExoCompanionAPI.requirement.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RequirementNotFoundException extends RuntimeException {
    public RequirementNotFoundException(String message) {
        super(message);
    }

    public RequirementNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequirementNotFoundException(Throwable cause) {
        super(cause);
    }

    public RequirementNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
