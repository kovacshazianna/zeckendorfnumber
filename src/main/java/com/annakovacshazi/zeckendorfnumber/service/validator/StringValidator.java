package com.annakovacshazi.zeckendorfnumber.service.validator;

import com.annakovacshazi.zeckendorfnumber.service.exception.ValidationException;

/**
 * Interface for validating the string input.
 *
 * @author Anna_Kovacshazi
 */
public interface StringValidator {

    /**
     * Validates the given word.
     * @param input
     * @throws ValidationException throws {@ValidationException} if the input is invalid
     */
    void validate(String input) throws ValidationException;

}
