package StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        String inputFile = "C:\\Users\\VaL\\Desktop\\input\\input.txt";
        FileInputStream input = new FileInputStream(inputFile);
        int oneByte = input.read();
        String outputFile = "C:\\Users\\VaL\\Desktop\\input\\03.CopyBytesOutput.txt";
        PrintWriter output = new PrintWriter(outputFile);
        while (oneByte >= 0) {
            if (oneByte == 10 || oneByte == 32) {
                output.print((char)oneByte);
            } else {
                output.print(oneByte);
            }
            oneByte = input.read();
        }
        output.close();
    }
}
