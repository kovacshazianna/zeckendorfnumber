package com.annakovacshazi.zeckendorfnumber.repository;

import com.annakovacshazi.zeckendorfnumber.service.exception.ValidationException;
import com.annakovacshazi.zeckendorfnumber.service.validator.IntervalValidator;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toMap;

/**
 * Generates the Zeckendorf representation of the numbers in the given interval.
 *
 * @author Anna_Kovacshazi
 */
public class ZeckendorfNumberGenerator {

    private final IntervalValidator intervalEndPointValidator;
    private final FibonacciListGenerator fibonacciListGenerator;

    public ZeckendorfNumberGenerator(IntervalValidator intervalValidator, FibonacciListGenerator fibonacciListGenerator) {
        this.intervalEndPointValidator = requireNonNull(intervalValidator);
        this.fibonacciListGenerator = requireNonNull(fibonacciListGenerator);
    }

    public Map<Integer, String> getZeckendorfRepresentationOfNumbersBetween(Integer start, Integer end) throws ValidationException {
        intervalEndPointValidator.validate(start, end);
        return IntStream.rangeClosed(start, end).boxed()
            .collect(toMap(Function.identity(), number -> getZeckendorfRepresentation(number, fibonacciListGenerator.fibonacciListUntil(number)),
                (v1, v2) -> { throw new RuntimeException(String.format("Duplicate key for values %s and %s", v1, v2));},
                    TreeMap::new));
    }

    private String getZeckendorfRepresentation(Integer number, List<Integer> fibonacciNumbers) {
        StringBuilder sb = new StringBuilder();
        if (fibonacciNumbers.isEmpty()) {
            sb.append("0");
        }
        for (int i = fibonacciNumbers.size() - 1; i >= 0; i--) {
            Integer fibNumber = fibonacciNumbers.get(i);
            if (fibNumber <= number) {
                sb.append("1");
                number = number - fibNumber;
            } else {
                sb.append("0");
            }
        }
        return sb.toString();
    }
}
