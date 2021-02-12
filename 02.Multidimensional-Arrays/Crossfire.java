package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        List<List<Integer>> matrix = readListMatrix(scan, dimensions);
        String input = scan.nextLine();
        while (!input.equalsIgnoreCase("Nuke it from orbit")) {
            int[] params = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int row = params[0];
            int col = params[1];
            int rad = params[2];
            if (rad >= 0) {
                //remove up
                for (int i = row - rad; i < row; i++) {
                    if (i >= 0 && i < matrix.size()) {
                        if (col >= 0 && col < matrix.get(i).size()) {
                            matrix.get(i).remove((int) col);
                        }
                    }
                }
                //remove down
                for (int i = row + 1; i <= row + rad; i++) {
                    if (i >= 0 && i < matrix.size()) {
                        if (col >= 0 && col < matrix.get(i).size()) {
                            matrix.get(i).remove((int) col);
                        }
                    }
                }
                //remove left and right
                for (int i = col + rad; i >= col - rad; i--) {
                    if (row < 0 || row >= matrix.size()) {
                        break;
                    }
                    if (i >= 0 && i < matrix.get(row).size()) {
                        matrix.get(row).remove((int) i);
                    }
                }
                for (int i = 0; i < matrix.size(); i++) {
                    if (matrix.get(i).isEmpty()) {
                        matrix.remove((int)i);
                    }
                }
            }
            input = scan.nextLine();
        }
        printMatrix(matrix);
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> readListMatrix(Scanner scan, int[] dimensions) {
        List<List<Integer>> newMatrix = new ArrayList<>();
        int num = 1;
        for (int row = 0; row < dimensions[0]; row++) {
            List<Integer> columns = new ArrayList<>();
            for (int col = 0; col < dimensions[1]; col++) {
                columns.add(num++);
            }
            newMatrix.add(columns);
        }
        return newMatrix;
    }
}
