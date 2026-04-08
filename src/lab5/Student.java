package lab5;
import java.util.Objects;

public class Student {
    private int id;
    private String nume;
    private String prenume;
    private String grupa;
    private double medie;

    public Student(int id, String nume, String prenume, String grupa, double medie) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.grupa = grupa;
        this.medie = medie;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Double.compare(student.medie, medie) == 0 &&
                Objects.equals(nume, student.nume) &&
                Objects.equals(prenume, student.prenume) &&
                Objects.equals(grupa, student.grupa);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, nume, prenume, grupa, medie);
    }
    @Override
    public String toString() {
        return "ID: " + id + ", Nume: " + nume + " " + prenume +
                ", Grupa: " + grupa + ", Medie: " + medie;
    }
}
