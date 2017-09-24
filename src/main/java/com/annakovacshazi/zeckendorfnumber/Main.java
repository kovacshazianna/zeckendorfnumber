package com.annakovacshazi.zeckendorfnumber;

import com.annakovacshazi.zeckendorfnumber.repository.FibonacciListGenerator;
import com.annakovacshazi.zeckendorfnumber.repository.ZeckendorfNumberGenerator;
import com.annakovacshazi.zeckendorfnumber.service.LineReader;
import com.annakovacshazi.zeckendorfnumber.service.exception.ValidationException;
import com.annakovacshazi.zeckendorfnumber.service.validator.*;

/**
 * Main class of the Application.
 *
 * @author Anna_Kovacshazi
 */
public class Main {
    private static final String PATTERN = "Z(%d) = %s";

    private static final LineReader lineReader = new LineReader();
    private static final StringValidator STRING_VALIDATOR = new StringIntegerValidator();
    private static final ZeckendorfNumberGenerator ZECKENDORF_NUMBER_GENERATOR =
            new ZeckendorfNumberGenerator(new IntervalEndpointValidator(), new FibonacciListGenerator());

    public static void main(String[] args) {
        try {
            Integer start = getInputAsInteger();
            Integer end = getInputAsInteger();
            ZECKENDORF_NUMBER_GENERATOR.getZeckendorfRepresentationOfNumbersBetween(start, end)
                .entrySet()
                .stream()
                .forEach(entry -> System.out.println(format(entry.getKey(), entry.getValue())));

        } catch (ValidationException ex) {
            handleError(ex.getMessage());
        } catch (Exception ex) {
            handleError("Something went wrong...");
        }
    }

    private static Integer getInputAsInteger() throws ValidationException {
        String line = lineReader.readLine();
        STRING_VALIDATOR.validate(line);
        return Integer.parseInt(line);
    }

    private static String format(Integer number, String representation) {
        return String.format(PATTERN, number, representation);
    }

    private static void handleError(String message) {
        System.err.println(message);
        System.exit(1);
    }
}
