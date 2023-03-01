package org.example.algo;

import org.example.DefaultTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MajorProblemTest extends DefaultTest {

    @DisplayName("Testing algorithm for classic case")
    @Test
    public void majorProblemTest1() {
        int[] array = {2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2};
        int b = MajorProblem.findMajorityElement(array);
        Assertions.assertEquals(2, b);
    }
}
//дописать тесты