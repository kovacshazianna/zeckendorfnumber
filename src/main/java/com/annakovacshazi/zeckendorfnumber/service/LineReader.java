package com.annakovacshazi.zeckendorfnumber.service;

import java.io.Console;

/**
 * Reads lines from the console.
 *
 * @author Anna_Kovacshazi
 */
public class LineReader {

    private final Console console;

    /**
     * Constructor.
     * Initialize a {@link Console} object to read from the console.
     */
    public LineReader() {
        console = System.console();
        if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }
    }

    /**
     * Reads a line from the console.
     * @return the value of the read line as a {@link String}
     */
    public String readLine() {
        return console.readLine("Enter number: ");
    }
}
