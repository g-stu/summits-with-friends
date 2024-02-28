package org.summits;

import lombok.NoArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@NoArgsConstructor
public class OriginalScraper {

    List<String> scrape() {
        Document doc;

        try {
            doc = Jsoup
                    .connect("https://www.walkhighlands.co.uk/Forum/memberlist.php?u=215303&mode=viewmap")
                    .validateTLSCertificates(false)
                    .userAgent("Chrome/108.0.0.0").validateTLSCertificates(false)
                    .get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Elements hills = doc.select("#scroll3");

        Pattern pattern1 = Pattern.compile("<span style=\"color:blue;\">(.*?)</span></a><br>");
        Pattern pattern2 = Pattern.compile("<span style=\"color:red;\">(.*?)</span></a><br>");

        Matcher matcher1 = pattern1.matcher(hills.toString());
        Matcher matcher2 = pattern2.matcher(hills.toString());
        Set hills2 = new HashSet<>();
        while (matcher1.find()) {
            hills2.add(matcher1.group(1));
        }
        while (matcher2.find()) {
            hills2.add(matcher2.group(1));
        }
        List hills3 = (List) hills2.stream().sorted().collect(Collectors.toList());

        for(Object h: hills3) {
            System.out.println(h.toString());
        }
        return List.of();
    }
}
