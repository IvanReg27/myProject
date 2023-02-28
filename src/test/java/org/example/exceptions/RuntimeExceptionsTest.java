package org.example.exceptions;

import org.example.DefaultTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RuntimeExceptionsTest extends DefaultTest {
    @Test
    void nullPointerException() {
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();
        assertThrows(
                NullPointerException.class,
                () -> runtimeExceptions.throwsNullPointerException(),
                "Had to trown an exception but it didn't"
        );
    }
    @Test
    void arrayIndexOutOfBoundsException() {
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();
        assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> runtimeExceptions.throwsArrayIndexOutOfBoundsException(),
                "Had to trown an exception but it didn't"
        );
    }
    @Test
    void numberFormatException() {
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();
        assertThrows(
                NumberFormatException.class,
                () -> runtimeExceptions.throwsNumberFormatException(),
                "Had to trown an exception but it didn't"
        );
    }
    @Test
    void illegalArgumentException() {
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();
        assertThrows(
                IllegalArgumentException.class,
                () -> runtimeExceptions.throwsIllegalArgumentException(),
                "Had to trown an exception but it didn't"
        );
    }
    @Test
    void classCastException() {
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();
        assertThrows(
                ClassCastException.class,
                () -> runtimeExceptions.throwsClassCastException(),
                "Had to trown an exception but it didn't"
        );
    }
}