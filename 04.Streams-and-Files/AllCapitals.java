package StreamsFilesDirectories;

import java.io.*;

public class AllCapitals {
    public static void main(String[] args) throws IOException {
        String inputFile = "C:\\Users\\VaL\\Desktop\\input\\input.txt";
        String outputFile = "C:\\Users\\VaL\\Desktop\\input\\output.txt";
        BufferedReader bf = new BufferedReader(new FileReader(inputFile));
        PrintWriter writer = new PrintWriter(new FileWriter(outputFile));
        String line = bf.readLine();
        while (line != null) {
            writer.println(line.toUpperCase());
            line = bf.readLine();
        }
        writer.close();
    }
}
