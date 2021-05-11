package ExamPreparation;

import java.util.Scanner;

public class Selling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[matrixSize][];
        int row = 0;
        int col = 0;
        for (int i = 0; i < matrixSize; i++) {
            String values = scan.nextLine();
            matrix[i] = values.toCharArray();
            if (values.contains("S")) {
                row = i;
                col = values.indexOf("S");
            }
        }
        int money = 0;
        while (money < 50) {
            String cmd = scan.nextLine();
            matrix[row][col] = '-';
            switch (cmd) {
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "left":
                    col--;
                    break;
                case "right":
                    col++;
                    break;
            }

            if (isInBounds(matrix, row, col)) {
                if (Character.isDigit(matrix[row][col])) {
                    money += Integer.parseInt(matrix[row][col] + "");
                    matrix[row][col] = 'S';
                } else {
                    if (matrix[row][col] == 'O') {
                        matrix[row][col] = '-';
                        for (int i = 0; i < matrix.length; i++) {
                            boolean isFound = false;
                            for (int j = 0; j < matrix[i].length; j++) {
                                if (matrix[i][j] == 'O') {
                                    row = i;
                                    col = j;
                                    isFound = true;
                                    break;
                                }
                            }
                            if (isFound)
                                break;
                        }
                    }
                    matrix[row][col] = 'S';
                }
            } else {
                break;
            }

        }
        if (money >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news, you are out of the bakery.");
        }
        System.out.println("Money: " + money);
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
