package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] matrix1params = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrixOne = ReadMatrix(scan, matrix1params[0], matrix1params[1]);
        int[] matrix2params = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrixTwo = ReadMatrix(scan, matrix2params[0], matrix2params[1]);
        if (checkMatricex(matrixOne, matrixTwo)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }
    public static boolean checkMatricex(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length) {
            return false;
        }
        for (int i = 0; i < matrix1.length; i++) {
            if (matrix1[i].length != matrix2[i].length) {
                return false;
            }
            for (int j = 0; j < matrix1[i].length; j++) {
                if (matrix1[i][j] != matrix2[i][j])
                    return false;
            }
        }
        return true;
    }

    public static int[][] ReadMatrix(Scanner scanner, int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            int[] values = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < columns; col++) {
                matrix[row][col] = values[col];
            }
        }
        return matrix;
    }
}
