package ExamPreparation;

import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int mSize = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[mSize][];
        int row = 0;
        int col = 0;
        int foodQuantity = 0;
        for (int i = 0; i < mSize; i++) {
            String input = scan.nextLine();
            matrix[i] = input.toCharArray();
            if (input.contains("S")) {
                row = i;
                col = input.indexOf("S");
            }
        }
        String input = scan.nextLine();
        while (true) {
            matrix[row][col] = '.';
            switch (input) {
                case "left":  col--;  break;
                case "right":  col++;  break;
                case "up":  row--;  break;
                case "down":  row++;  break;
            }
            if (isInBounds(matrix, row, col)) {
                if (matrix[row][col] == '*') {
                    foodQuantity++;
                } else if (matrix[row][col] == 'B') {
                    matrix[row][col] = '.';
                    for (int i = 0; i < matrix.length; i++) {
                        for (int j = 0; j < matrix[i].length; j++) {
                            if (matrix[i][j] == 'B') {
                                row = i;
                                col = j;
                                break;
                            }
                        }
                    }
                }
                matrix[row][col] = 'S';
            } else {
                System.out.println("Game over!");
                break;
            }
            if (foodQuantity == 10) {
                System.out.println("You won! You fed the snake.");
                break;
            }
            input = scan.nextLine();
        }
        System.out.printf("Food eaten: %d%n", foodQuantity);
        printMatrix(matrix);
    }

    private static boolean isInBounds(char[][] matrix, int row, int col) {
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
