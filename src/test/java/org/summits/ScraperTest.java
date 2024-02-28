package org.summits;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScraperTest {

    private Scraper scraper;

    @BeforeEach
    void setUp() {
        scraper = new Scraper();
    }

    @Test
    void returnsAList() {
        assertEquals(177, scraper.scrape("215303").size());
    }
}