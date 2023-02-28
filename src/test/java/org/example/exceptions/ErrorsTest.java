package org.example.exceptions;

import org.example.DefaultTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ErrorsTest extends DefaultTest {
    @Test
    public void throwsOutOfMemoryError() {
        Errors error = new Errors();
        assertThrows(
                OutOfMemoryError.class,
                () -> error.throwsOutOfMemoryError(),
                "Had to trow an exception but it didn't"
        );
    }
    @Test
    public void throwsStackOverflowError() {
        Errors error = new Errors();
        assertThrows(
                StackOverflowError.class,
                () -> error.throwsStackOverflowError(),
                "Had to trow an exception but it didn't"
        );
    }
}