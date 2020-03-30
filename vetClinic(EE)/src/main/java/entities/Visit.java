package entities;

import java.util.Date;
import java.util.Objects;

public class Visit {
    private int id;
    private Date visitDateTime;
    private boolean visited;
    private Veterinarian vet;
    private Pet pet;

    public Visit() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Date getVisitDateTime() {
        return visitDateTime;
    }

    public void setVisitDateTime(Date visitDateTime) {
        this.visitDateTime = visitDateTime;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Veterinarian getVet() {
        return vet;
    }

    public void setVet(Veterinarian vet) {
        this.vet = vet;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return visited == visit.visited &&
                Objects.equals(visitDateTime, visit.visitDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitDateTime, visited);
    }

    @Override
    public String toString() {
        return "Visit{" +
                "visitDateTime=" + visitDateTime +
                ", visited=" + visited +
                '}';
    }
}
