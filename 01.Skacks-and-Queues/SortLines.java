package StreamsFilesDirectories;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {
        String inputFile = "C:\\Users\\VaL\\Desktop\\input\\input.txt";
        String outputFile = "C:\\Users\\VaL\\Desktop\\input\\06.SortLinesOutput.txt";
        List<String> doc = Files.readAllLines(Path.of(inputFile));
        PrintWriter out = new PrintWriter(new FileWriter(outputFile));
        Collections.sort(doc);
        for (String s : doc
             ) {
            out.println(s);
        }
        out.close();
    }
}
