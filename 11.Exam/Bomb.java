package Exam;

import java.util.Scanner;

public class Bomb {
    static int startRow;
    static int startCol;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scan.nextLine());
        String[] cmds = scan.nextLine().split(",\\s*");
        char[][] matrix = readMatrix(scan, fieldSize);
        int bombs = bombsRemaining(matrix);
        for (String cmd : cmds) {
            matrix[startRow][startCol] = '+';
            switch (cmd) {
                case "up":
                    startRow--;
                    if (startRow < 0) {
                        startRow++;
                    }
                    break;
                case "down":
                    startRow++;
                    if (startRow >= matrix.length) {
                        startRow--;
                    }
                    break;
                case "left":
                    startCol--;
                    if (startCol < 0) {
                        startCol++;
                    }
                    break;
                case "right":
                    startCol++;
                    if (startCol >= matrix.length) {
                        startCol--;
                    }
                    break;
            }
            if (matrix[startRow][startCol] == 'e') {
                System.out.printf("END! %d bombs left on the field%n", bombs);
                return;
            } else if (matrix[startRow][startCol] == 'B') {
                System.out.println("You found a bomb!");
                bombs--;
            }
            matrix[startRow][startCol] = 's';
            if (bombs == 0) {
                break;
            }
        }
        if (bombs > 0) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n", bombs, startRow, startCol);
        } else {
            System.out.println("Congratulations! You found all bombs!");
        }
    }

    public static int bombsRemaining(char[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'B') {
                    count++;
                }
            }
        }
        return count;
    }

    private static char[][] readMatrix(Scanner scan, int size) {
        char[][] matrix = new char[size][size];
        for (int i = 0; i < matrix.length; i++) {
            String input = scan.nextLine();
            input = input.replaceAll("\\s+", "");
            matrix[i] = input.toCharArray();
            if (input.contains("s")) {
                startRow = i;
                startCol = input.indexOf("s");
            }
        }
        return matrix;
    }

}
