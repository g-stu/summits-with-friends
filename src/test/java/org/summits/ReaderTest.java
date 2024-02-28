package org.summits;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {

    private Reader reader;

    @BeforeEach
    void setUp() {
        reader = new Reader();
    }

    @Test
    void readsListCorrectly() {
        List<String> list = reader.readListFromTxt("src/test/resources/test.txt");
        assertEquals(List.of("123", "abc"), list);
    }
}