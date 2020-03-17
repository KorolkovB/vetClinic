package entities;

import java.util.List;
import java.util.Objects;

public class Kind {
    private int id;
    private String name;
    private List<Pet> pets;

    public Kind() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kind kind = (Kind) o;
        return Objects.equals(name, kind.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Kind{" +
                "name='" + name + '\'' +
                '}';
    }
}
