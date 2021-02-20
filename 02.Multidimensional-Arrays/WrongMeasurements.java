package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix = readMatrix(scan);
        int[] coordinates = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int wrongNumber = matrix[coordinates[0]][coordinates[1]];
        int[][] correctedMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                correctedMatrix[i][j] = matrix[i][j];
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongNumber) {
                    int numUp = 0;  int numDown = 0;    int numLeft = 0;    int numRight = 0;
                    if (row > 0 && matrix[row-1][col] != wrongNumber) {
                        numUp = matrix[row-1][col];
                    }
                    if (row < matrix.length-1 && matrix[row+1][col] != wrongNumber) {
                        numDown = matrix[row+1][col];
                    }
                    if (col > 0 && matrix[row][col-1] != wrongNumber) {
                        numLeft = matrix[row][col-1];
                    }
                    if (col < matrix[row].length-1 && matrix[row][col+1] != wrongNumber) {
                        numRight = matrix[row][col+1];
                    }
                    correctedMatrix[row][col] = numUp+numDown+numLeft+numRight;
                }
            }
        }
        for (int row = 0; row < correctedMatrix.length; row++) {
            for (int col = 0; col < correctedMatrix[row].length; col++) {
                System.out.print(correctedMatrix[row][col]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] readMatrix (Scanner scanner) {
        int matrixSize = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[matrixSize][];
        for (int row = 0; row < matrixSize; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
