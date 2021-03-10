package DefiningClasses.PokemonTrainer;

public class Pokemon {
    String name;
    String element;
    double health;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public Pokemon(String name, String element, double health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }
}
