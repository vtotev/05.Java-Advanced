package StreamsFilesDirectories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String inputFile = "C:\\Users\\VaL\\Desktop\\input\\input.txt";
        String outputFile = "C:\\Users\\VaL\\Desktop\\input\\05.WriteEveryThirdLineOutput.txt";
        List<String> doc = Files.readAllLines(Path.of(inputFile));
        PrintWriter output = new PrintWriter(new FileWriter(outputFile));
        for (int i = 2; i < doc.size(); i+=3) {
            output.println(doc.get(i));
        }
        output.close();
    }
}
