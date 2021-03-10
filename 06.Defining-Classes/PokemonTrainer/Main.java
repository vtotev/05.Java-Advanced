package DefiningClasses.PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, Trainer> trainerMap = new LinkedHashMap<>();
        while (!input.equalsIgnoreCase("Tournament")) {
            String[] cmd = input.split("\\s+");
            if (!trainerMap.containsKey(cmd[0])) {
                trainerMap.put(cmd[0], new Trainer(cmd[0], 0, new ArrayList<>()));
            }
            Pokemon pokemon = new Pokemon(cmd[1], cmd[2], Double.parseDouble(cmd[3]));
            trainerMap.get(cmd[0]).getPokemons().add(pokemon);
            input = scan.nextLine();
        }

        input = scan.nextLine();
        while (!input.equalsIgnoreCase("end")) {
            for (Map.Entry<String, Trainer> trainer : trainerMap.entrySet()) {
                boolean pokemonFound = isPokemonFound(input, trainer);
                if (pokemonFound) {
                    trainer.getValue().addBadge();
                } else {
                    trainer.getValue().missingPokemonPenalty();
                }
            }
            input = scan.nextLine();
        }
        trainerMap.entrySet().stream().sorted((o1, o2) -> Integer.compare(o2.getValue().getNumOfBadges(), o1.getValue().getNumOfBadges()))
                .forEach(o -> System.out.printf("%s %d %d%n", o.getKey(), o.getValue().getNumOfBadges(), o.getValue().getPokemons().size()));
    }

    private static boolean isPokemonFound(String input, Map.Entry<String, Trainer> trainer) {
        for (Pokemon pokemon : trainer.getValue().getPokemons()) {
            if (pokemon.getElement().equalsIgnoreCase(input)) {
                return true;
            }
        }
        return false;
    }
}