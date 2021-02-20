package SetsAndMapsAdvanced;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, Set<String>> playerResults = new LinkedHashMap<>();
        while (!input.equalsIgnoreCase("JOKER")) {
            String[] player = input.split(": ");
            String[] cards = player[1].split(", ");
            Set<String> cardsList = new LinkedHashSet<>();
            if (playerResults.containsKey(player[0])) {
                cardsList = playerResults.get(player[0]);
            }
            for (String card : cards) {
                cardsList.add(card);
            }
            playerResults.put(player[0], cardsList);
            input = scan.nextLine();
        }
        for (Map.Entry<String, Set<String>> entry : playerResults.entrySet()) {
            int sum = 0;
            for (String card : entry.getValue()) {
                char power = card.charAt(0);
                char type;
                if (card.charAt(0) == '1' && card.charAt(1) == '0') {
                    type = card.charAt(2);
                } else {
                    type = card.charAt(1);
                }

                int cardPower = 0;
                int multiplier = 0;
                switch (power) {
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        cardPower = Integer.parseInt(power + "");
                        break;
                    case '1':
                        if (card.charAt(1) == '0') {
                            cardPower = 10;
                        }
                        break;
                    case 'J':
                        cardPower = 11;
                        break;
                    case 'Q':
                        cardPower = 12;
                        break;
                    case 'K':
                        cardPower = 13;
                        break;
                    case 'A':
                        cardPower = 14;
                        break;
                }
                switch (type) {
                    case 'S':
                        multiplier = 4;
                        break;
                    case 'H':
                        multiplier = 3;
                        break;
                    case 'D':
                        multiplier = 2;
                        break;
                    case 'C':
                        multiplier = 1;
                        break;
                }
                sum += (cardPower * multiplier);
            }
            System.out.printf("%s: %d%n", entry.getKey(), sum);
        }
    }
}
