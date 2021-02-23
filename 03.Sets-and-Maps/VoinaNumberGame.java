package SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashSet<Integer> playerOne = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(LinkedHashSet::new));
        LinkedHashSet<Integer> playerTwo = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(LinkedHashSet::new));
        int games = 50;
        while (games-- > 0 && !playerOne.isEmpty() && !playerTwo.isEmpty()) {
            int firstNum = playerOne.iterator().next();
            playerOne.remove(firstNum);
            int secNum = playerTwo.iterator().next();
            playerTwo.remove(secNum);
            if (firstNum > secNum) {
                playerOne.add(firstNum);
                playerOne.add(secNum);
            } else if (secNum > firstNum) {
                playerTwo.add(firstNum);
                playerTwo.add(secNum);
            }
        }
        if (playerOne.size() == playerTwo.size()) {
            System.out.println("Draw!");
        } else  if (playerOne.size() > playerTwo.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Second player win!");
        }
    }
}
