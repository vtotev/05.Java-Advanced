package StreamsFilesDirectories;

import java.io.*;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        String inputFile = "C:\\Users\\VaL\\Desktop\\input\\inputLineNumbers.txt";
        String outputFile = "C:\\Users\\VaL\\Desktop\\input\\output.txt";
        int lineNumber = 1;
        BufferedReader bf = new BufferedReader(new FileReader(inputFile));
        PrintWriter writer = new PrintWriter(new FileWriter(outputFile));
        String line = bf.readLine();
        while (line != null) {
            writer.printf("%d. %s%n", lineNumber, line);
            lineNumber++;
            line = bf.readLine();
        }
        writer.close();
    }
}
