package ExamPreparation;

import java.util.Scanner;

public class ReVolt {
    static int col;
    static int row;
    static boolean won = false;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int mSize = Integer.parseInt(scan.nextLine());
        if (mSize < 2) {
            return;
        }
        int commandsCount = Integer.parseInt(scan.nextLine());
        char[][] matrix = readMatrix(scan, mSize);
        for (int i = 0; i < commandsCount; i++) {
            String cmd = scan.nextLine().trim();
            switch (cmd) {
                case "up":
                case "down":
                case "left":
                case "right":
                    reVolt(matrix, cmd);
                    break;
            }
            if (won) {
                System.out.println("Player won!");
                break;
            }
        }
        if (!won) {
            System.out.println("Player lost!");
        }
        printMatrix(matrix);
    }

    private static void reVolt(char[][] matrix, String cmd) {
        matrix[row][col] = '-';
        move(matrix, cmd);
        if (matrix[row][col] == 'B') {
            move(matrix, cmd);
        } else if (matrix[row][col] == 'T') {
            moveBack(matrix, cmd);
        } else if (matrix[row][col] == 'F') {
            matrix[row][col] = 'f';
            won = true;
            return;
        }
        matrix[row][col] = 'f';
    }

    private static void move(char[][] matrix, String cmd) {
        switch (cmd) {
            case "up":
                row--;
                if (row < 0) {
                    row = matrix.length - 1;
                }
                break;
            case "down":
                row++;
                if (row >= matrix.length) {
                    row = 0;
                }
                break;
            case "left":
                col--;
                if (col < 0) {
                    col = matrix.length - 1;
                }
                break;
            case "right":
                col++;
                if (col >= matrix.length) {
                    col = 0;
                }
                break;
        }
    }

    private static void moveBack(char[][] matrix, String cmd) {
        switch (cmd) {
            case "up":
                row++;
                if (row >= matrix.length) {
                    row = 0;
                }
                break;
            case "down":
                row--;
                if (row < 0) {
                    row = matrix.length - 1;
                }
                break;
            case "left":
                col++;
                if (col >= matrix.length) {
                    col = 0;
                }
                break;
            case "right":
                col--;
                if (col < 0) {
                    col = matrix.length - 1;
                }
                break;
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static char[][] readMatrix(Scanner scan, int size) {
        char[][] matrix = new char[size][size];
        for (int i = 0; i < matrix.length; i++) {
            String input = scan.nextLine();
            matrix[i] = input.toCharArray();
            if (input.contains("f")) {
                row = i;
                col = input.indexOf("f");
            }
        }
        return matrix;
    }

    private static boolean isInBounds(char[][] matrix, int row, int col) {
        return row >= 0 && col >= 0 && row < matrix.length && col < matrix.length;
    }

}
