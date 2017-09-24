package com.annakovacshazi.zeckendorfnumber.service.validator;

import com.annakovacshazi.zeckendorfnumber.service.exception.ValidationException;

/**
 * Interface for validating the interval.
 *
 * @author Anna_Kovacshazi
 */
public interface IntervalValidator {
    /**
     * Validates the given word.
     * @param start beginning of the intervalc
     * @param end end of the interval
     * @throws ValidationException throws {@ValidationException} if the interval is invalid
     */
    void validate(Integer start, Integer end) throws ValidationException;
}
