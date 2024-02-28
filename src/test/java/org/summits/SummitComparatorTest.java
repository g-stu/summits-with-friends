package org.summits;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SummitComparatorTest {
    private SummitComparator summitComparator;
    private Reader reader;
    private Scraper scraper;

    @BeforeEach
    void setUp() {
        reader = new Reader();
        scraper = new Scraper();
        summitComparator = new SummitComparator(reader, scraper);
    }

    @Test
    public void returnsOnlyBenNevis() {
        assertEquals(List.of("Ben Nevis"), summitComparator.findNewSummitsForUsers());
    }

}