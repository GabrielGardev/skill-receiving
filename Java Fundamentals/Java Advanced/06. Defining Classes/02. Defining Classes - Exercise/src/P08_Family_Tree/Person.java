package P08_Family_Tree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String birthDate;

    private List<Person> parents;
    private List<Person> children;

    public Person() {
        this.name = null;
        this.birthDate = null;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<Person> getParents() {
        return parents;
    }

    public void setParents(List<Person> parents) {
        this.parents = parents;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getBirthDate();
    }
}
