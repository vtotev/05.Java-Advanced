package StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteToFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\VaL\\Desktop\\input\\input.txt";
        FileInputStream input = new FileInputStream(path);
        List<Character> punctuation = new ArrayList<>();
        punctuation.add(',');
        punctuation.add('.');
        punctuation.add('!');
        punctuation.add('?');
        FileOutputStream output = new FileOutputStream("C:\\Users\\VaL\\Desktop\\input\\02.WriteToFileOutput.txt");
        int oneByte = input.read();
        while (oneByte>=0) {
            if (!punctuation.contains((char)oneByte)) {
                output.write((char)oneByte);
            }
            oneByte = input.read();
        }
        output.close();
    }
}
