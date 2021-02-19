package MultidimensionalArrays;

import java.util.ArrayDeque;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> wordsDeq = new ArrayDeque<>();
        String command = scan.nextLine();
        String input = scan.nextLine();
        int longestWord = 0;
        while (!input.equalsIgnoreCase("end")) {
            wordsDeq.offer(input);
            if (input.length() > longestWord) {
                longestWord = input.length();
            }
            input = scan.nextLine();
        }
        String[][] wordsArr = new String[wordsDeq.size()][longestWord];
        for (int i = 0; i < wordsArr.length; i++) {
            String[] letters = wordsDeq.poll().split("");
            for (int j = 0; j < letters.length; j++) {
                wordsArr[i][j] = letters[j];
            }
            for (int j = letters.length; j < wordsArr[i].length; j++) {
                wordsArr[i][j] = " ";
            }
        }
        String[][] rotatedMatrix = getRotatedMatrix(command, wordsArr, longestWord);
        for (int i = 0; i < rotatedMatrix.length; i++) {
            for (int j = 0; j < rotatedMatrix[i].length; j++) {
                System.out.print(rotatedMatrix[i][j]);
            }
            System.out.println();
        }
    }

    private static String[][] getRotatedMatrix(String command, String[][] matrix, int longestWord) {
        int degrees = Integer.parseInt(command.substring(command.indexOf('(')+1, command.indexOf(')')));
        while (degrees >= 360){
            degrees = degrees % 360;
        }
        switch (degrees) {
            case 0:
            case 360:
                return matrix;
            case 90:
                return rotate90(matrix, longestWord);
            case 180:
                return rotate180(matrix, longestWord);
            case 270:
                return rotate270(matrix, longestWord);

        }
        return matrix;
    }

    private static String[][] rotate270(String[][] matrix, int longestWord) {
        String[][] rotated270Matrix = new String[longestWord][matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                rotated270Matrix[matrix[row].length -1 - col][row] = matrix[row][col];
            }
        }
        return rotated270Matrix;
    }

    private static String[][] rotate180(String[][] matrix, int longestWord) {
        String[][] rotated180Matrix = new String[matrix.length][longestWord];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                rotated180Matrix[row][col] = matrix[matrix.length-1-row][matrix[row].length-1-col];
            }
        }
        return rotated180Matrix;
    }

    private static String[][] rotate90(String[][] matrix, int longestWord) {
        String[][] rotated90Matrix = new String[longestWord][matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                rotated90Matrix[col][row] = matrix[matrix.length -1 - row][col];
            }
        }
        return rotated90Matrix;
    }

}
