package ExamPreparation;

import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int mSize = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[mSize][mSize];
        int startRow = 0;
        int startCol = 0;
        for (int i = 0; i < matrix.length; i++) {
            String input = scan.nextLine();
            matrix[i] = input.toCharArray();
            if (input.contains("B")) {
                startRow = i;
                startCol = input.indexOf("B");
            }
        }
        int pollinatedFlowers = 0;

        String input = scan.nextLine();
        while (!input.equalsIgnoreCase("end")) {
            matrix[startRow][startCol] = '.';
            switch (input) {
                case "up":   startRow--; break;
                case "down": startRow++; break;
                case "left": startCol--; break;
                case "right":startCol++; break;
            }

            if (isInRange(matrix, startRow, startCol)) {
                if (matrix[startRow][startCol] == 'f') {
                    matrix[startRow][startCol] = 'B';
                    pollinatedFlowers++;
                } else if (matrix[startRow][startCol] == 'O') {
                    matrix[startRow][startCol] = '.';
                    switch (input) {
                        case "up":   startRow--; break;
                        case "down": startRow++; break;
                        case "left": startCol--; break;
                        case "right":startCol++; break;
                    }
                    if (isInRange(matrix, startRow, startCol)) {
                        if (matrix[startRow][startCol] == 'f') {
                            pollinatedFlowers++;
                        }
                        matrix[startRow][startCol] = 'B';
                    } else {
                        printGetLost();
                        break;
                    }
                } else {
                    matrix[startRow][startCol] = 'B';
                }
            } else {
                printGetLost();
                break;
            }
            input = scan.nextLine();
        }
        if (pollinatedFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
        }
        printMatrix(matrix);
    }

    public static void printGetLost() {
        System.out.println("The bee got lost!");
    }
    public static boolean isInRange(char[][] matrix, int row, int col) {
        return row >= 0 && col >= 0 && row < matrix.length && col < matrix.length;
    }

    public static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
