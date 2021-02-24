package StreamsFilesDirectories;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String inputFile = "C:\\Users\\VaL\\Desktop\\input\\input.txt";
        String outputFile = "C:\\Users\\VaL\\Desktop\\input\\output.txt";
        int vowelsCount = 0;
        int punctuationsCount = 0;
        int ConsonantsCount = 0;
        Set<Character> vowels = new LinkedHashSet<>();
        vowels.add('a'); vowels.add('e'); vowels.add('i');
        vowels.add('o'); vowels.add('u');
        Set<Character> punctuations = new LinkedHashSet<>();
        punctuations.add('.'); punctuations.add('!');
        punctuations.add(','); punctuations.add('?');

        BufferedReader bf = new BufferedReader(new FileReader(inputFile));
        String line = bf.readLine();
        while (line != null) {
            for (int i = 0; i < line.length(); i++) {
                if (vowels.contains(line.charAt(i))) {
                    vowelsCount++;
                } else if (punctuations.contains(line.charAt(i))) {
                    punctuationsCount++;
                } else if (line.charAt(i) != ' '){
                    ConsonantsCount++;
                }
            }
            line = bf.readLine();
        }

        PrintWriter writer = new PrintWriter(new FileWriter(outputFile));
        writer.println("Vowels: "+vowelsCount);
        writer.println("Consonants: "+ConsonantsCount);
        writer.println("Punctuation: "+punctuationsCount);
        writer.close();
    }
}
