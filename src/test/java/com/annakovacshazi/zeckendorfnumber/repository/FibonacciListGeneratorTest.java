package com.annakovacshazi.zeckendorfnumber.repository;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Unit test for {@link FibonacciListGenerator}.
 *
 * @author Anna_Kovacshazi
 */
public class FibonacciListGeneratorTest {
    private FibonacciListGenerator generator;

    @BeforeMethod
    public void init() {
        generator = new FibonacciListGenerator();
    }

    @Test(dataProvider = "getData")
    public void shouldGenerateFibonacciNumbersUntil(Integer number, List<Integer> fibonacciList) {
        assertThat(generator.fibonacciListUntil(number), is(fibonacciList));
    }

    @DataProvider
    private Object[][] getData() {
        return new Object[][] {
            {0, Collections.emptyList()},
            {1, Arrays.asList(1)},
            {2, Arrays.asList(1, 2)},
            {3, Arrays.asList(1, 2, 3)},
            {10, Arrays.asList(1, 2, 3, 5, 8)},
            {13, Arrays.asList(1, 2, 3, 5, 8, 13)}
        };
    }
}
