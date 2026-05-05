import java.util.Objects;

public class Student {
    private int id;
    private String prenume;
    private String nume;
    private String formatieDeStudiu;

    public Student(int id, String prenume, String nume, String formatieDeStudiu) {
        this.id = id;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(prenume, student.prenume) &&
                Objects.equals(nume, student.nume) &&
                Objects.equals(formatieDeStudiu, student.formatieDeStudiu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prenume, nume, formatieDeStudiu);
    }
}