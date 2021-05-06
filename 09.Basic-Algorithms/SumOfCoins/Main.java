package BasicAlgorithms.SumOfCoins;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static int sum = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] elements = scan.nextLine().substring(7).split(", ");
        int[] coins = Arrays.stream(elements).mapToInt(Integer::parseInt).toArray();
        int targetSum = Integer.parseInt(scan.nextLine().substring(5));
        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);
        usedCoins.entrySet().forEach(o -> sum += o.getValue());
        System.out.println("Number of coins to take: "+sum);;
        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.printf("%d coin(s) with value %d%n", usedCoin.getValue(), usedCoin.getKey());
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        Map<Integer, Integer> chosenCoins = new LinkedHashMap<>();
        List<Integer> sortedCoins = Arrays.stream(coins).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        int currSum = 0;
        int coinIndex = 0;

        while (currSum != targetSum && coinIndex < coins.length) {
            int currCoin = sortedCoins.get(coinIndex);
            int moneyLeft = targetSum - currSum;
            int numberOfCoins = moneyLeft / currCoin;
            if (currSum + currCoin <= targetSum) {
                chosenCoins.put(currCoin, numberOfCoins);
                currSum += numberOfCoins * currCoin;
            }
            coinIndex++;
        }
        if (currSum != targetSum) {
            throw new IllegalArgumentException("Error");
        }
        return chosenCoins;
    }
}
