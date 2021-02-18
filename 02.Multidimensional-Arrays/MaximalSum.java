package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] params = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = readMatrix(scan, params[0], params[1]);
        int[] maxMatrixPos = getMaxMatrixPosition(matrix);
        System.out.println("Sum = " + maxMatrixPos[2]);
        for (int r = maxMatrixPos[0]; r < maxMatrixPos[0] + 3; r++) {
            for (int c = maxMatrixPos[1]; c < maxMatrixPos[1] + 3; c++) {
                System.out.print(matrix[r][c]+" ");
            }
            System.out.println();
        }
    }

    private static int[] getMaxMatrixPosition(int[][] matrix) {
        int[] position = new int[3];
        int sum = 0;
        for (int r = 0; r < matrix.length - 2; r++) {
            for (int c = 0; c < matrix[r].length - 2; c++) {
                int sumRows = matrix[r][c] + matrix[r][c + 1] + matrix[r][c + 2] +
                        matrix[r + 1][c] + matrix[r + 1][c + 1] + matrix[r + 1][c + 2] +
                        matrix[r + 2][c] + matrix[r + 2][c + 1] + matrix[r + 2][c + 2];
                if (sumRows > sum) {
                    sum = sumRows;
                    position[0] = r;
                    position[1] = c;
                    position[2] = sum;
                }
            }
        }
        return position;
    }

    private static int[][] readMatrix(Scanner scan, int rows, int cols) {
        int[][] matrix = new int[rows][];
        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).limit(cols).toArray();
        }
        return matrix;
    }
}
