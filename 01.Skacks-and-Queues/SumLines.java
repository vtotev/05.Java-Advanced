package StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SumLines {
    public static void main(String[] args) throws IOException {
        String inputFile = "C:\\Users\\VaL\\Desktop\\input\\input.txt";
        BufferedReader bf = Files.newBufferedReader(Path.of(inputFile));
        String line = bf.readLine();
        while (line != null) {
            long sum = 0;
            for (char ch : line.toCharArray()
                 ) {
                sum += ch;
            }
            System.out.println(sum);
            line = bf.readLine();
        }
    }
}
