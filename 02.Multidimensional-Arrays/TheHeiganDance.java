package MultidimensionalArrays;

import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean waitingHit = false;
        int[] playerCoordinates = new int[]{7, 7};
        int playerHP = 18500;
        double bossHP = 3000000.0;
        int plagueCloud = 3500;
        int eruption = 6000;
        double damageDone = Double.parseDouble(scan.nextLine());
        String lastSpell = "";
        String input = scan.nextLine();
        while (playerHP > 0 && bossHP > 0) {
            bossHP -= damageDone;
            if (waitingHit) {
                playerHP -= plagueCloud;
                waitingHit = false;
            }
            if (playerHP < 0) {
                break;
            }
            if (bossHP < 0) {
                break;
            }
            String[] cmd = input.split("\\s+");
            int row = Integer.parseInt(cmd[1]);
            int col = Integer.parseInt(cmd[2]);

            Integer[][] matrix = new Integer[15][15];
            for (int r = row - 1; r <= row + 1; r++) {
                if (r >= 0 && r < matrix.length) {
                    for (int c = col - 1; c <= col + 1; c++) {
                        if (c >= 0 && c < matrix[r].length) {
                            matrix[r][c] = 1;
                        }
                    }
                }
            }
            if (matrix[playerCoordinates[0]][playerCoordinates[1]] != null) {
                playerCoordinates = getNewCoordinates(matrix, playerCoordinates);
                if (matrix[playerCoordinates[0]][playerCoordinates[1]] != null) {
                    switch (cmd[0]) {
                        case "Cloud":
                            playerHP -= plagueCloud;
                            waitingHit = true;
                            lastSpell = "Plague Cloud";
                            break;

                        case "Eruption":
                            playerHP -= eruption;
                            lastSpell = cmd[0];
                            break;
                    }
                }
            }
            if (playerHP < 0) {
                break;
            }
            if (bossHP < 0) {
                break;
            }
            input = scan.nextLine();
        }
        if (bossHP > 0) {
            System.out.printf("Heigan: %.2f%n", bossHP);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (playerHP > 0) {
            System.out.printf("Player: %d%n", playerHP);
        } else {
            System.out.println("Player: Killed by " + lastSpell);
        }

        System.out.println("Final position: " + playerCoordinates[0] + ", " + playerCoordinates[1]);
    }

    public static int[] getNewCoordinates(Integer[][] matrix, int[] playerCoords) {
        int[] newCoords = new int[]{playerCoords[0], playerCoords[1]};
        int playerRow = playerCoords[0];
        int playerCol = playerCoords[1];
        //up
        if (isRowValid(matrix, playerRow - 1) && matrix[playerRow - 1][playerCol] == null) {
            newCoords[0]--;
            return newCoords;
        }
        //right
        if (isColValid(matrix, playerRow, playerCol + 1) && matrix[playerRow][playerCol + 1] == null) {
            newCoords[1]++;
            return newCoords;
        }
        //down
        if (isRowValid(matrix, playerRow + 1) && matrix[playerRow + 1][playerCol] == null) {
            newCoords[0]++;
            return newCoords;
        }
        //left
        if (isColValid(matrix, playerRow, playerCol - 1) && matrix[playerRow][playerCol - 1] == null) {
            newCoords[1]--;
            return newCoords;
        }
        return newCoords;
    }

    private static boolean isRowValid(Integer[][] matrix, int row) {
        return row >= 0 && row < matrix.length;
    }

    private static boolean isColValid(Integer[][] matrix, int row, int col) {
        return col >= 0 && col < matrix[row].length;
    }

}
