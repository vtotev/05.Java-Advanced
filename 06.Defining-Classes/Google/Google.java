package DefiningClasses.Google;

import java.util.LinkedHashMap;
import java.util.Map;

public class Google {
    private String personName;
    private Company company = new Company();
    private Map<String, String> pokemons = new LinkedHashMap<>();
    private Map<String, String> parents = new LinkedHashMap<>();
    private Map<String, String> children = new LinkedHashMap<>();
    private Car car = new Car();

    public Company getCompany() {
        return company;
    }

    public Google(String personName) {
        this.personName = personName;
    }

    public String getPersonName() {
        return personName;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void addPokemon(String name, String type) {
        this.pokemons.put(name, type);
    }

    public void addParent(String name, String birthday) {
        this.parents.put(name, birthday);
    }

    public void addChildren(String name, String birthday) {
        this.children.put(name, birthday);
    }

    public void setCompany(String name, String department, double salary) {
        this.company.setCompanyName(name);
        this.company.setDepartment(department);
        this.company.setSalary(salary);
    }

    public void printPerson() {
        System.out.println(getPersonName());
        System.out.println("Company:");
        if (getCompany().getCompanyName() != null) {
            System.out.printf("%s %s %.2f%n", getCompany().getCompanyName(), getCompany().getDepartment(),
                    getCompany().getSalary());
        }
        System.out.println("Car:");
        if (getCar().getModel() != null) {
            System.out.printf("%s %d%n", getCar().getModel(), getCar().getSpeed());
        }
        System.out.println("Pokemon:");
        this.pokemons.entrySet().forEach(p -> System.out.printf("%s %s%n", p.getKey(), p.getValue()));
        System.out.println("Parents:");
        this.parents.entrySet().forEach(p -> System.out.printf("%s %s%n", p.getKey(), p.getValue()));
        System.out.println("Children:");
        this.children.entrySet().forEach(p -> System.out.printf("%s %s%n", p.getKey(), p.getValue()));
    }
}
