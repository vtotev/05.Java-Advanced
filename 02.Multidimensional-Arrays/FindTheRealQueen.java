package MultidimensionalArrays;

import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[][] matrix = readMatrix(scan);
        System.out.println();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equalsIgnoreCase("q")) {
                    if (checkQueen(matrix, row, col)) {
                        System.out.printf("%d %d%n", row, col);
                        return;
                    }
                }
            }
        }
    }
    public static boolean checkQueen(String[][] matrix, int row, int col) {
        for (int i = 0; i < matrix.length; i++) {
            if (row != i && matrix[i][col].equalsIgnoreCase("q")) {
                return false;
            }
        }
        for (int i = 0; i < matrix[row].length; i++) {
            if (i != col && matrix[row][i].equalsIgnoreCase("q")) {
                return false;
            }
        }
        for (int r = row-1, c = col-1; r >= 0 && c >= 0; r--, c--) {
            if (matrix[r][c].equalsIgnoreCase("q")) {
                return false;
            }
        }
        for (int r = row+1, c = col-1; r < matrix.length && c >= 0; r++, c--) {
            if (matrix[r][c].equalsIgnoreCase("q")) {
                return false;
            }
        }
        for (int r = row-1, c = col+1; r >= 0 && c < matrix[r].length; r--, c++) {
            if (matrix[r][c].equalsIgnoreCase("q")) {
                return  false;
            }
        }
        for (int r = row+1, c = col+1; r < matrix.length && c < matrix[r].length; r++, c++) {
            if (matrix[r][c].equalsIgnoreCase("q")) {
                return false;
            }
        }
        return true;
    }

    public static String[][] readMatrix(Scanner scan) {
        String[][] newMatrix = new String[8][8];
        for (int i = 0; i < 8; i++) {
            newMatrix[i] = scan.nextLine().split("\\s+");
        }
        return newMatrix;
    }
}
