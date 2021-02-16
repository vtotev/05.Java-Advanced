package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = readMatrix(scan, dimensions);
        String input = scan.nextLine();
        while (!input.equalsIgnoreCase("END")) {
            String[] cmd = input.split("\\s+");
            try {
                int row1 = Integer.parseInt(cmd[1]);
                int col1 = Integer.parseInt(cmd[2]);
                int row2 = Integer.parseInt(cmd[3]);
                int col2 = Integer.parseInt(cmd[4]);
                String currValue = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = currValue;
                printMatrix(matrix);
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
            input = scan.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static String[][] readMatrix(Scanner scan, int[] dimensions) {
        String[][] matrix = new String[dimensions[0]][dimensions[1]];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scan.nextLine().split("\\s+");
        }
        return matrix;
    }
}
