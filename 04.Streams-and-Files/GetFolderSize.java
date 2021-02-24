package StreamsFilesDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetFolderSize {
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\VaL\\Desktop\\input\\Exercises Resources";
        Path folder = Paths.get(fileName);
        long size = Files.walk(folder)
                .filter(p -> p.toFile().isFile())
                .mapToLong(p -> p.toFile().length())
                .sum();
        System.out.println("Folder size: "+size);
    }
}
