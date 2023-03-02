package org.example.algorithm;

import algorithm.WordSearchAlgo;
import org.example.DefaultTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WordSearchAlgoTest extends DefaultTest {

    @DisplayName("Test check that between cat and zoz there is a path")
    @Test
    public void ok() {
        WordSearchAlgo wordSearchAlgo = new WordSearchAlgo();
        boolean hasConnection = wordSearchAlgo.hasConnection("cat", "zoz", new String[]{"cot", "zot"});
        Assertions.assertTrue(hasConnection);
    }

    @DisplayName("Test check that between cat and zoz there is no path")
    @Test
    public void notOk() {
        WordSearchAlgo wordSearchAlgo = new WordSearchAlgo();
        boolean hasConnection = wordSearchAlgo.hasConnection("cat", "zoz", new String[]{"ppt", "zot"});
        Assertions.assertFalse(hasConnection);
    }

    @DisplayName("Test check that invalid head or tail has not path")
    @Test
    public void missingHead() {
        WordSearchAlgo wordSearchAlgo = new WordSearchAlgo();
        boolean hasConnection = wordSearchAlgo.hasConnection(null, "zoz", new String[]{"ppt", "zot"});
        Assertions.assertFalse(hasConnection);
        hasConnection = wordSearchAlgo.hasConnection("", "zoz", new String[]{"ppt", "zot"});
        Assertions.assertFalse(hasConnection);
        hasConnection = wordSearchAlgo.hasConnection("aaaa", "zoz", new String[]{"ppt", "zot"});
        Assertions.assertFalse(hasConnection);
    }

    @DisplayName("Test check that invalid words have not path")
    @Test
    public void missingWords() {
        WordSearchAlgo wordSearchAlgo = new WordSearchAlgo();
        boolean hasConnection = wordSearchAlgo.hasConnection(null, "zoz", null);
        Assertions.assertFalse(hasConnection);
    }
}