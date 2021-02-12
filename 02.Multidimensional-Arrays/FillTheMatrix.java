package MultidimensionalArrays;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] commands = scan.nextLine().split("\\s+");
        int[][] matrix = readMatrix(Integer.parseInt(commands[0]), commands[1]);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(int size, String pattern) {
        int[][] matrix = new int[size][size];
        int num = 1;
        for (int col = 0; col < matrix[0].length; col++) {
            if (pattern.equalsIgnoreCase("A")) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = num++;
                }
            } else {
                if (col % 2 == 0) {
                    for (int row = 0; row < matrix.length; row++) {
                        matrix[row][col] = num++;
                    }
                } else {
                    for (int row = matrix.length-1; row >= 0; row--) {
                        matrix[row][col] = num++;
                    }
                }
            }
        }
        return matrix;
    }
}
