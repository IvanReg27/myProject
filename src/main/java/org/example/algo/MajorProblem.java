package org.example.algo;

import java.util.HashMap;

public class MajorProblem {
    // O(N) algorithm complexity
    public static int findMajorityElement(int[] input) {

        int[] array = {2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2};
        //int[] array = new int[]{1, 3, 1, 1};

        HashMap<Integer, Integer> map = new HashMap<>();

        Integer value = null;
        for (Integer i : array) {
            value = map.get(i);
            if (value == null) {
                map.put(i, 1);
            } else {
                map.put(i, ++value);
            }
        }
        Integer maxKey = null;
        for (Integer key : map.keySet()) {
            if (maxKey == null || map.get(key) > map.get(maxKey)) {
                maxKey = key;
            }
        }
        return maxKey;
    }
}

// Для заданного массива вернуть число которое встречается чаще всех остальных
//Input : [2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2]
//Output: 2
//
//Input : [1, 3, 1, 1]
//Output: 1