package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix = readMatrix(scan);
        int[] maxMatrix = getMaxMatrixindex(matrix);
        getMaxMatrix(matrix, maxMatrix);
    }

    public static void getMaxMatrix(int[][] matrix, int[] matrixIndex) {
        int[][] newMatrix = new int[2][2];
        int sum = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                newMatrix[i][j] = matrix[matrixIndex[0]+i][matrixIndex[1]+j];
                sum += newMatrix[i][j];
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(sum);
    }

    public static int[] getMaxMatrixindex(int[][] matrix) {
        int maxMatrixIndex[] = new int[2];
        int sum = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int currSum = matrix[row][col] + matrix[row][col+1] + matrix[row+1][col] + matrix[row+1][col+1];
                if (currSum > sum) {
                    sum = currSum;
                    maxMatrixIndex[0] = row;
                    maxMatrixIndex[1] = col;
                }
            }
        }
        return maxMatrixIndex;
    }

    public static int[][] readMatrix (Scanner scanner) {
        int[] params = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = params[0];
        int cols = params[1];
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] values = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = values[col];
            }
        }
        return matrix;
    }
}
