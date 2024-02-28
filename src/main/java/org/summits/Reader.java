package org.summits;

import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Reader {
    List<String> readListFromTxt(String fileName) {
        List<String> values = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                values.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Boom");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Major boom");
            throw new RuntimeException(e);
        }
        return values;
    };
}
