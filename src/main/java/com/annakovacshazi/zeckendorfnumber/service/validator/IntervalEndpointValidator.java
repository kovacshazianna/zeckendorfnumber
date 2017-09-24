package com.annakovacshazi.zeckendorfnumber.service.validator;

import com.annakovacshazi.zeckendorfnumber.service.exception.ValidationException;

/**
 * Validates the endpoints of the given interval.
 *
 * @author Anna_Kovacshazi
 */
public class IntervalEndpointValidator implements IntervalValidator {
    @Override
    public void validate(Integer start, Integer end) throws ValidationException {
        if (start == null || end == null || start >= end) {
            throw new ValidationException("Invalid interval: endpoint must be greater than the start point");
        }
    }
}
