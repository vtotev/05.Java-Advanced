package DefiningClasses.PokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Trainer {
    String name;
    int numOfBadges = 0;
    List<Pokemon> pokemons = new ArrayList<>();

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfBadges() {
        return numOfBadges;
    }

    public void addBadge(){
        this.numOfBadges += 1;
    }

    private UnaryOperator<Pokemon> damagePokemon = pokemon ->
            new Pokemon(pokemon.getName(), pokemon.getElement(), pokemon.getHealth() - 10);

    public void missingPokemonPenalty() {
        this.pokemons = this.pokemons
                .stream()
                .map(damagePokemon)
                .filter(pokemon -> pokemon.getHealth() > 0)
                .collect(Collectors.toList());
    }

    public Trainer(String name, int numOfBadges, List<Pokemon> pokemons) {
        this.name = name;
        this.numOfBadges = numOfBadges;
        this.pokemons = pokemons;
    }
}
