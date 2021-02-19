package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = readMatrix(scan, dimensions);
        for (int mainCol = matrix[matrix.length-1].length-1; mainCol >= 0; mainCol--) {
            for (int row = matrix.length-1, col = mainCol; row >= 0 && col < matrix[row].length; row--, col++) {
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }
        if (matrix.length > 1) {
            for (int mainRow = matrix.length-2; mainRow >= 0; mainRow--) {
                for (int row = mainRow, col = 0; row >= 0 && col < matrix[row].length; row--, col++) {
                    System.out.print(matrix[row][col]+" ");
                }
                System.out.println();
            }
        }
    }

    private static int[][] readMatrix(Scanner scan, int[] dimensions) {
        int[][] matrix = new int[dimensions[0]][dimensions[1]];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
