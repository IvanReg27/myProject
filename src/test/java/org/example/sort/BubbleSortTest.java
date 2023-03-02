package org.example.sort;

import org.example.DefaultTest;
import org.junit.jupiter.api.Test;
import sort.BubbleSort;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BubbleSortTest extends DefaultTest {

    @Test
    public void BubbleSort() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] sortedArray = BubbleSort.BubbleSort(array);
        assertThat(sortedArray, equalTo(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}