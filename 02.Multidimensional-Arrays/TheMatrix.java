package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        char[][] matrix = readMatrix(scan, dimensions);
        char fillChar = scan.nextLine().charAt(0);
        int[] startPos = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        fillWithChar(matrix, startPos[0], startPos[1], fillChar, matrix[startPos[0]][startPos[1]]);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    private static void fillWithChar(char[][] matrix, int row, int col, char fillChar, char startChar) {
        if (matrix[row][col] != startChar) {
            return;
        }

        matrix[row][col] = fillChar;

        if (row + 1 < matrix.length) {
            fillWithChar(matrix, row + 1, col, fillChar, startChar);
        }

        if (row - 1 >= 0) {
            fillWithChar(matrix, row - 1, col, fillChar, startChar);
        }

        if (col + 1 < matrix[row].length) {
            fillWithChar(matrix, row, col + 1, fillChar, startChar);
        }

        if (col - 1 >= 0) {
            fillWithChar(matrix, row, col - 1, fillChar, startChar);
        }
    }
    private static char[][] readMatrix(Scanner scan, int[] dimensions) {
        char[][] newMatrix = new char[dimensions[0]][dimensions[1]];
        for (int i = 0; i < newMatrix.length; i++) {
            newMatrix[i] = scan.nextLine().replaceAll("\\s+", "").toCharArray();
//            String[] input = scan.nextLine().split("\\s+");
//            for (int j = 0; j < newMatrix[i].length; j++) {
//                newMatrix[i][j] = input[j].charAt(0);
//            }
        }
        return newMatrix;
    }
}
