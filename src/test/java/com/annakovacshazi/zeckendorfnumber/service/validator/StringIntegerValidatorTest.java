package com.annakovacshazi.zeckendorfnumber.service.validator;

import com.annakovacshazi.zeckendorfnumber.service.exception.ValidationException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Unit test for {@link StringIntegerValidator}.
 *
 * @author Anna_Kovacshazi
 */
public class StringIntegerValidatorTest {
    private StringIntegerValidator validator;

    @BeforeMethod
    public void init() {
        validator = new StringIntegerValidator();
    }

    @Test(expectedExceptions = ValidationException.class)
    public void shouldThrowExceptionWhenInputIsNull() throws ValidationException{
        validator.validate(null);
    }

    @Test(expectedExceptions = ValidationException.class, dataProvider = "getInvalidIntegers")
    public void shouldThrowExceptionWhenInputIsNotAnInteger(String input) throws ValidationException{
        validator.validate(input);
    }

    @Test(dataProvider = "getValidIntegers")
    public void shouldBeValid(String input) throws ValidationException {
        validator.validate(input);
    }

    @DataProvider
    private Object[][] getInvalidIntegers() {
        return new Object[][] {
            new Object[] {"1c"},
            new Object[] {"abc123"},
            new Object[] {"123.4"},
            new Object[] {"-10"}
        };
    }

    @DataProvider
    private Object[][] getValidIntegers() {
        return new Object[][] {
            new Object[] {"1"},
            new Object[] {"10"},
            new Object[] {"0"}
        };
    }
}
