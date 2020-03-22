package entities;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Veterinarian {
    private int id;
    private String firstName;
    private String lastName;
    private Date hiringDate;
    private Date dismissalDate;
    private List<Specialization> specializations;
    private List<Visit> visits;

    public Veterinarian() {
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    public List<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<Specialization> specializations) {
        this.specializations = specializations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(Date hiringDate) {
        this.hiringDate = hiringDate;
    }

    public Date getDismissalDate() {
        return dismissalDate;
    }

    public void setDismissalDate(Date dismissalDate) {
        this.dismissalDate = dismissalDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veterinarian that = (Veterinarian) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(hiringDate, that.hiringDate) &&
                Objects.equals(dismissalDate, that.dismissalDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, hiringDate, dismissalDate);
    }

    @Override
    public String toString() {
        return "Veterinarian{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hiringDate=" + hiringDate +
                ", dismissalDate=" + dismissalDate +
                '}';
    }
}
