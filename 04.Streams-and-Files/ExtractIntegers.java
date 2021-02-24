package StreamsFilesDirectories;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String inputFile = "C:\\Users\\VaL\\Desktop\\input\\input.txt";
        String outputFile = "C:\\Users\\VaL\\Desktop\\input\\04.ExtractIntegersOutput.txt";
        Scanner scan = new Scanner(new FileInputStream(inputFile));
        PrintWriter output = new PrintWriter(outputFile);
        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                output.println(scan.nextInt());
            }
            scan.next();
        }
        output.close();;
    }
}
