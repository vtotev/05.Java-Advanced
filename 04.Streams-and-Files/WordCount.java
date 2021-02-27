package StreamsFilesDirectories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) throws IOException {
        String inputFile = "C:\\Users\\VaL\\Desktop\\input\\text.txt";
        String wordsFile = "C:\\Users\\VaL\\Desktop\\input\\words.txt";
        String outputFile = "C:\\Users\\VaL\\Desktop\\input\\output.txt";
        Map<String, Integer> words = new LinkedHashMap<>();
        List<String> fr = Files.readAllLines(Path.of(wordsFile));
        for (String f : fr) {
            String[] splitWords = f.split("\\s+");
            for (String w: splitWords
                 ) {
                words.put(w, 0);
            }
        }
        for (Map.Entry<String, Integer> e: words.entrySet()
             ) {
            System.out.println(e.getKey());
        }

        BufferedReader bf = new BufferedReader(new FileReader(inputFile));
        String input = bf.readLine();
        while (input != null) {
            String[] currWord = input.split("\\s+");
            for (String w: currWord
                 ) {
                if (words.containsKey(w)) {
                    words.put(w, words.get(w)+1);
                }
            }

            input = bf.readLine();
        }
        PrintWriter writer = new PrintWriter(new FileWriter(outputFile));
        words.entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).forEach(o -> writer.printf("%s - %d%n", o.getKey(), o.getValue()));
        writer.close();
    }
}
