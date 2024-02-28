package org.summits;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
public class SummitComparator {

    private Reader reader;
    private Scraper scraper;

//    private static List<String> hills1 = List.of("A' Bhuidheanach Bheag", "A' Chailleach (Fannichs)");
//    private static List<String> hills2 = List.of("A' Bhuidheanach Bheag", "A' Chailleach (Monadhliath)", "A' Chralaig");
//
//    private static final List<String> munros = List.of("A' Bhuidheanach Bheag", "A' Chailleach (Monadhliath)", "A' Chralaig", "Ben Nevis");

    List<String> findNewSummitsForUsers() {
        List<String> userIds = reader.readListFromTxt("src/main/resources/users.txt");
        Set<String> combinedSummitList = getCombinedSummitList(userIds);
        return reader.readListFromTxt("src/main/resources/munros.txt").stream()
                .filter(m -> !combinedSummitList.contains(m))
                .collect(Collectors.toList());
    }

    private Set<String> getCombinedSummitList(List<String> userIds) {
        return userIds
                .stream()
                .map(scraper::scrape)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

}
