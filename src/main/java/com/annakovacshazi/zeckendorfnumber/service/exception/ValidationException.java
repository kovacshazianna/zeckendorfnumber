package com.annakovacshazi.zeckendorfnumber.service.exception;

import static java.util.Objects.requireNonNull;

/**
 * Represents an exception.
 *
 * @author Anna_Kovacshazi
 */
public class ValidationException extends Exception {

    private final String message;

    public ValidationException(String message) {
        this.message = requireNonNull(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
