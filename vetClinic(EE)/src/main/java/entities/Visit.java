package entities;

import java.util.Date;
import java.util.Objects;

public class Visit {
    private int id;
    private Date visitDateTime;
    private boolean visited;

    public Visit() {
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
