package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scan.nextLine());
        int[][] matrix = readMatrix(scan, matrixSize);
        int primaryDiagonalSum = getPrimarySum(matrix);
        int secondaryDiagonalSum = getSecondarySum(matrix);
        System.out.println(Math.abs(primaryDiagonalSum-secondaryDiagonalSum));
    }

    private static int getPrimarySum(int[][] matrix) {
        int sum = 0;
        for (int row = 0, col = 0; row < matrix.length && col < matrix[row].length; row++, col++) {
            sum += matrix[row][col];
        }
        return sum;
    }
    private static int getSecondarySum(int[][] matrix) {
        int sum = 0;
        for (int row = 0, col = matrix[row].length-1; row < matrix.length && col >= 0; row++, col--) {
            sum += matrix[row][col];
        }
        return sum;
    }

    private static int[][] readMatrix(Scanner scan, int matrixSize) {
        int[][] matrix = new int[matrixSize][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
