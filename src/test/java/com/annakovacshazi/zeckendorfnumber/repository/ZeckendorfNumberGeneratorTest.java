package com.annakovacshazi.zeckendorfnumber.repository;

import com.annakovacshazi.zeckendorfnumber.service.exception.ValidationException;
import com.annakovacshazi.zeckendorfnumber.service.validator.IntervalValidator;
import com.google.common.collect.ImmutableMap;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

/**
 * Unit test for @{link ZeckendorfNumberGenerator}.
 *
 * @author Anna_Kovacshazi
 */
public class ZeckendorfNumberGeneratorTest {

    private static final List<Integer> UNTIL_ONE = Arrays.asList(1);
    private static final List<Integer> UNTIL_TWO = Arrays.asList(1, 2);
    private static final List<Integer> UNTIL_THREE = Arrays.asList(1, 2, 3);
    private static final List<Integer> UNTIL_FIVE = Arrays.asList(1, 2, 3, 5);
    private static final List<Integer> UNTIL_EIGHT = Arrays.asList(1, 2, 3, 5, 8);
    private static final List<Integer> UNTIL_THIRTEEN = Arrays.asList(1, 2, 3, 5, 8, 13);

    private ZeckendorfNumberGenerator generator;

    @Mock
    private IntervalValidator intervalEndPointValidator;

    @Mock
    private FibonacciListGenerator fibonacciListGenerator;

    @BeforeMethod
    public void init() {
        MockitoAnnotations.initMocks(this);
        generator = new ZeckendorfNumberGenerator(intervalEndPointValidator, fibonacciListGenerator);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void shouldThrowExceptionWhenValidatorIsNull() {
        new ZeckendorfNumberGenerator(null, fibonacciListGenerator);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void shouldThrowExceptionWhenFibonacciListGeneratorIsNull() {
        new ZeckendorfNumberGenerator(intervalEndPointValidator, null);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void shouldThrowExceptionWhenIntervalIsInvalid() throws ValidationException {
        doThrow(new ValidationException("exception")).when(intervalEndPointValidator).validate(10, 20);
        generator.getZeckendorfRepresentationOfNumbersBetween(10, 20);
    }

    @Test(dataProvider = "getData")
    public void shouldGetZeckendorfRepresentationOfNumbers(int[] range, Map<Integer, String> representation) throws ValidationException {
        doNothing().when(intervalEndPointValidator).validate(range[0], range[1]);
        initFibonacciNumbers();
        assertThat(generator.getZeckendorfRepresentationOfNumbersBetween(range[0], range[1]), equalTo(representation));
    }

    @DataProvider
    private Object[][] getData() {
        return new Object[][] {
            {new int[] {0, 1}, ImmutableMap.of(0, "0", 1, "1")},
            {new int[] {1, 5}, ImmutableMap.of(1, "1", 2, "10", 3, "100", 4, "101", 5, "1000")},
            {new int[] {12, 16}, ImmutableMap.of(12, "10101", 13, "100000", 14, "100001", 15, "100010", 16, "100100")}
        };
    }

    private void initFibonacciNumbers() {
        when(fibonacciListGenerator.fibonacciListUntil(1)).thenReturn(UNTIL_ONE);
        when(fibonacciListGenerator.fibonacciListUntil(2)).thenReturn(UNTIL_TWO);
        when(fibonacciListGenerator.fibonacciListUntil(3)).thenReturn(UNTIL_THREE);
        when(fibonacciListGenerator.fibonacciListUntil(4)).thenReturn(UNTIL_THREE);
        when(fibonacciListGenerator.fibonacciListUntil(5)).thenReturn(UNTIL_FIVE);
        when(fibonacciListGenerator.fibonacciListUntil(6)).thenReturn(UNTIL_FIVE);
        when(fibonacciListGenerator.fibonacciListUntil(7)).thenReturn(UNTIL_FIVE);
        when(fibonacciListGenerator.fibonacciListUntil(8)).thenReturn(UNTIL_EIGHT);
        when(fibonacciListGenerator.fibonacciListUntil(9)).thenReturn(UNTIL_EIGHT);
        when(fibonacciListGenerator.fibonacciListUntil(10)).thenReturn(UNTIL_EIGHT);
        when(fibonacciListGenerator.fibonacciListUntil(11)).thenReturn(UNTIL_EIGHT);
        when(fibonacciListGenerator.fibonacciListUntil(12)).thenReturn(UNTIL_EIGHT);
        when(fibonacciListGenerator.fibonacciListUntil(13)).thenReturn(UNTIL_THIRTEEN);
        when(fibonacciListGenerator.fibonacciListUntil(14)).thenReturn(UNTIL_THIRTEEN);
        when(fibonacciListGenerator.fibonacciListUntil(15)).thenReturn(UNTIL_THIRTEEN);
        when(fibonacciListGenerator.fibonacciListUntil(16)).thenReturn(UNTIL_THIRTEEN);
    }
}
