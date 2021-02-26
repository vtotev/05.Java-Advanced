package StreamsFilesDirectories;

import java.io.File;
import java.util.ArrayDeque;

public class NestedFolders {
    public static int counter = 0;

    public static void main(String[] args) {
        String inputFile = "C:\\Users\\VaL\\Desktop\\input";
        File file = new File(inputFile);
        ArrayDeque<File> folders = new ArrayDeque<>();
        folders.offer(file);
        while (!folders.isEmpty()) {
            File current = folders.poll();
            File[] nestedFiles = current.listFiles();
            for (File f : nestedFiles
            ) {
                if (f.isDirectory()) {
                    folders.offer(f);
                    counter++;
                    System.out.println(f.getName());
                }
            }
        }
        System.out.println(counter + " folders");
    }
}
