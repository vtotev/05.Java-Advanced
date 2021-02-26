package StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\VaL\\Desktop\\input\\input.txt";
        FileInputStream input = new FileInputStream(fileName);
        int oneByte = input.read();
        while (oneByte >= 0) {
            System.out.printf("%s ", Integer.toBinaryString(oneByte));
            oneByte = input.read();
        }
    }
}
