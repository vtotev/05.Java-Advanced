package StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        String inputFile = "C:\\Users\\VaL\\Desktop\\input\\input.txt";
        BufferedReader bf = new BufferedReader(new FileReader(inputFile));
        String line = bf.readLine();
        long sum = 0;
        while (line != null) {
            for (char ch: line.toCharArray()
                 ) {
                sum += ch;
            }
            line = bf.readLine();
        }
        System.out.println(sum);
    }
}
