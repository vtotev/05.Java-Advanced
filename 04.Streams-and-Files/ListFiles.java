package StreamsFilesDirectories;

import java.io.File;
import java.util.List;

public class ListFiles {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\VaL\\Desktop\\input\\Files-and-Streams";
        String outputFile = "C:\\Users\\VaL\\Desktop\\input\\Files-and-Streams\\utput.txt";
        File file = new File(inputFile);
        File[] listFiles = file.listFiles();
        for (File f: listFiles
             ) {
            if (!f.isDirectory()) {
                System.out.printf("%s: [%d]%n", f.getName(), f.length());
            }
        }
    }
}
