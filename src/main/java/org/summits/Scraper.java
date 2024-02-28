package org.summits;

import lombok.NoArgsConstructor;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@NoArgsConstructor
public class Scraper {

    private final static String BASE_URL ="https://www.walkhighlands.co.uk/Forum/memberlist.php?u=%s&mode=viewmap";

    List<String> scrape(String userId) {
        Document doc;

        try {
            doc = Jsoup
                    .connect(String.format(BASE_URL, userId))
                    .validateTLSCertificates(false)
                    .userAgent("Chrome/108.0.0.0").validateTLSCertificates(false)
                    .get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Elements hills = doc.select("#scroll3");

        Pattern pattern = Pattern.compile("<span style=\"color:blue;\">(.*?)</span></a><br>");
        Matcher matcher = pattern.matcher(hills.toString());
        List<String> hillNames = new ArrayList<>();
        while (matcher.find()) {
            hillNames.add(matcher.group(1));
        }

        return hillNames;
    }
}
