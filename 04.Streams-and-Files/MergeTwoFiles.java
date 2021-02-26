package StreamsFilesDirectories;

import java.io.*;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String fileOne = "C:\\Users\\VaL\\Desktop\\input\\inputOne.txt";
        String fileTwo = "C:\\Users\\VaL\\Desktop\\input\\inputTwo.txt";
        String outputFile = "C:\\Users\\VaL\\Desktop\\input\\output.txt";
        BufferedReader bf = new BufferedReader(new FileReader(fileOne));
        PrintWriter writer = new PrintWriter(new FileWriter(outputFile));
        String input = bf.readLine();
        while (input != null) {
            writer.println(input);
            input = bf.readLine();
        }
        bf.close();

        bf = new BufferedReader(new FileReader(fileTwo));
        input = bf.readLine();
        while (input != null) {
            writer.println(input);
            input = bf.readLine();
        }
        bf.close();

        writer.close();;
    }
}
