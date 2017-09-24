package com.annakovacshazi.zeckendorfnumber.service.validator;

import com.annakovacshazi.zeckendorfnumber.service.exception.ValidationException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Unit test for {@link IntervalEndpointValidator}.
 *
 * @author Anna_Kovacshazi
 */
public class IntervalEndpointValidatorTest {

    private IntervalEndpointValidator validator;

    @BeforeMethod
    public void init() {
        validator = new IntervalEndpointValidator();
    }

    @Test(expectedExceptions = ValidationException.class)
    public void shouldThrowExceptionWhenIntervalStartIsNull() throws ValidationException{
        validator.validate(null, 10);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void shouldThrowExceptionWhenIntervalEndIsNull() throws ValidationException{
        validator.validate(10, null);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void shouldThrowExceptionWhenIntervalStartIsGreaterThanIntervalEndNull() throws ValidationException{
        validator.validate(20, 10);
    }

    @Test
    public void shouldBeValid() throws ValidationException {
        validator.validate(10, 20);
    }
}
