package com.annakovacshazi.zeckendorfnumber.service.validator;

import com.annakovacshazi.zeckendorfnumber.service.exception.ValidationException;

import static java.util.Objects.nonNull;

/**
 * Class for validating that the given input is an integer.
 * The pattern allows only non-negative numbers.
 *
 * @author Anna_Kovacshazi
 */
public class StringIntegerValidator implements StringValidator {
    private static final String PATTERN = "^\\d+$";

    @Override
    public void validate(String input) throws ValidationException {
        if (!nonNull(input) || !input.matches(PATTERN)) {
            throw new ValidationException("Invalid number");
        }
    }
}
