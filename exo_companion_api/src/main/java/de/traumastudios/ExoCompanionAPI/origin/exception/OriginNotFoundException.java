package de.traumastudios.ExoCompanionAPI.origin.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OriginNotFoundException extends RuntimeException {
  public OriginNotFoundException(String message) {
    super(message);
  }

  public OriginNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public OriginNotFoundException(Throwable cause) {
    super(cause);
  }

  public OriginNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
