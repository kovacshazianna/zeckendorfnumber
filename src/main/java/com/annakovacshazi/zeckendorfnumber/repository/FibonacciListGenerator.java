package com.annakovacshazi.zeckendorfnumber.repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates the list of the fibonacci numbers until a given number.
 *
 * @author Anna_Kovacshazi
 */
public class FibonacciListGenerator {

    public List<Integer> fibonacciListUntil(Integer number) {
        List<Integer> fibonacciNumbers = new ArrayList<>();
        if (number > 0) {
            fibonacciNumbers.add(1);
            Integer next = 2;
            while (next <= number) {
                fibonacciNumbers.add(next);
                next += fibonacciNumbers.get(fibonacciNumbers.size() - 2);
            }
        }
        return fibonacciNumbers;
    }
}
