package org.summits;

public class Main {

    public static void main(String[] args) {
        Reader reader = new Reader();
        Scraper scraper = new Scraper();
        var result = new SummitComparator(reader, scraper).findNewSummitsForUsers();
        System.out.println(result);
        System.out.println(result.size());
    }
}