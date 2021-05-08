package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> bombEffects = Arrays.stream(scan.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> bombCasing = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(",\\s+")).map(Integer::parseInt).forEach(bombCasing::push);
        Map<String, Integer> bombs = new TreeMap<>();
        bombs.put("Datura Bombs", 0);
        bombs.put("Cherry Bombs", 0);
        bombs.put("Smoke Decoy Bombs", 0);
        boolean isReady = false;
        while (!bombEffects.isEmpty() && !bombCasing.isEmpty()) {
            int effect = bombEffects.poll();
            int casing = bombCasing.pop();
            int sum = effect + casing;
            switch (sum) {
                case 40:
                    bombs.put("Datura Bombs", bombs.get("Datura Bombs") + 1);
                    break;
                case 60:
                    bombs.put("Cherry Bombs", bombs.get("Cherry Bombs") + 1);
                    break;
                case 120:
                    bombs.put("Smoke Decoy Bombs", bombs.get("Smoke Decoy Bombs") + 1);
                    break;
                default:
                    while (true) {
                        casing -= 5;
                        sum = effect + casing;
                        if (sum == 40 || sum == 60 || sum == 120) {
                            break;
                        }
                    }
                    switch (sum) {
                        case 40:
                            bombs.put("Datura Bombs", bombs.get("Datura Bombs") + 1);
                            break;
                        case 60:
                            bombs.put("Cherry Bombs", bombs.get("Cherry Bombs") + 1);
                            break;
                        case 120:
                            bombs.put("Smoke Decoy Bombs", bombs.get("Smoke Decoy Bombs") + 1);
                            break;
                    }
                    break;
            }
            isReady = isPouchReady(bombs);
            if (isReady) {
                break;
            }
        }
        if (isReady) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (bombEffects.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.println("Bomb Effects: " + bombEffects.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (bombCasing.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.println("Bomb Casings: " + bombCasing.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        bombs.entrySet().forEach(b -> System.out.printf("%s: %d%n", b.getKey(), b.getValue()));
//        System.out.println(effects.poll());
//        System.out.println(casing.pop());

    }

    private static boolean isPouchReady(Map<String, Integer> bombs) {
        return bombs.get("Datura Bombs") >= 3 &&
                bombs.get("Cherry Bombs") >= 3 &&
                bombs.get("Smoke Decoy Bombs") >= 3;
    }
}
