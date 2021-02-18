package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        boolean[][] parkingLot = new boolean[dimensions[0]][dimensions[1]];
        for (int i = 0; i < parkingLot.length; i++) {
            parkingLot[i][0] = true;
        }
        String input = scan.nextLine();
        while (!input.equals("stop")) {
            int[] coordinates = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int entry = coordinates[0];
            int row = coordinates[1];
            int col = coordinates[2];
            if (isRowFull(parkingLot, row)) {
                System.out.printf("Row %d full%n", row);
            } else {
                int counter = Math.abs(entry - row) + 1;

                if (isSpotTaken(parkingLot, row, col)) {
                    int leftPos = 0>=col - 1 ? 1 : col-1;
                    int rightPos = col + 1>=parkingLot[0].length-1 ? col : col+1;
                    while (parkingLot[row][leftPos]) {
                        if(leftPos==0){
                            break;
                        }
                        leftPos--;
                    }
                    while (parkingLot[row][rightPos]) {
                        if(rightPos == parkingLot[0].length-1){
                            break;
                        }
                        rightPos++;
                    }

                    if ((col - leftPos) <= Math.abs(rightPos - col)) {
                        col = leftPos;
                    } else {
                        col = rightPos;
                    }

                    if(col <=1 && parkingLot[row][col]){
                        col = rightPos;
                    }
                    if(parkingLot[row][col] && rightPos == parkingLot[0].length-1){
                        col = leftPos;
                    }

                    parkingLot[row][col] = true;
                    counter += col;
                    System.out.println(counter);
                } else {
                    parkingLot[row][col] = true;
                    counter += col;
                    System.out.println(counter);
                }

            }
            input = scan.nextLine();
        }
    }

    public static boolean isSpotTaken(boolean[][] matrix, int row, int col) {
        return (row >= 0 && row < matrix.length) && (col > 0 && col < matrix[row].length) && matrix[row][col];
    }

    public static boolean isRowFull(boolean[][] matrix, int row) {
        for (int i = 1; i < matrix[row].length; i++) {
            if (!matrix[row][i]) {
                return false;
            }
        }
        return true;
    }

    public static void printMatrix(boolean[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
