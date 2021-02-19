package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix = readMatrix(scan);
        for (int row = 0, col = 0; row < matrix.length && col < matrix.length; row++, col++) {
            System.out.print(matrix[row][col]+" ");
        }
        System.out.println();
        for (int row = matrix.length-1, col = 0; row >= 0 && col < matrix.length; row--, col++) {
            System.out.print(matrix[row][col]+" ");
        }
    }

    public static int[][] readMatrix (Scanner scanner) {
        int matrixSize = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int row = 0; row < matrixSize; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).limit(matrixSize).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }

}
