package entities;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Disease {
    private int id;
    private String name;
    private boolean isActive;
    private Date diagnosisDate;
    private List<Pet> pets;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
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
        Disease disease = (Disease) o;
        return isActive == disease.isActive &&
                Objects.equals(name, disease.name) &&
                Objects.equals(diagnosisDate, disease.diagnosisDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isActive, diagnosisDate);
    }

    @Override
    public String toString() {
        return "Disease{" +
                "name='" + name + '\'' +
                ", isActive=" + isActive +
                ", diagnosisDate=" + diagnosisDate +
                '}';
    }
}
