package P07_Google;

import java.util.ArrayList;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private ArrayList<Pokemon> pokemons;
    private ArrayList<Parent> parents;
    private ArrayList<Children> children;

    public Person(String name) {
        this.name = name;
        this.company = null;
        this.car = null;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public ArrayList<Parent> getParents() {
        return parents;
    }

    public ArrayList<Children> getChildren() {
        return children;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Company getCompany() {
        return company;
    }

    public Car getCar() {
        return car;
    }
}
