import java.util.Objects;
class Student {
    private String id;
    private String prenume;
    private String nume;
    private String grupa;
    private float nota;

    public Student(String id, String prenume, String nume, String grupa) {
        this.id = id;
        this.prenume = prenume;
        this.nume = nume;
        this.grupa = grupa;
    }

    public void setNota(float nota) { this.nota = nota; }
    public String getId() { return id; }
    public String getNume() { return nume; }
    public String getPrenume() { return prenume; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id + ", " + prenume + " " + nume + ", Grupa: " + grupa + ", Nota: " + nota;
    }
}