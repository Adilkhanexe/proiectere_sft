package lab5;
import java.util.Objects;
public class StudentBursier extends Student {
    private double cuantumBursa;
    public StudentBursier(int id, String nume, String prenume, String grupa, double medie, double cuantumBursa) {
        super (id, nume, prenume, grupa, medie);
        this.cuantumBursa = cuantumBursa;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentBursier)) return false;
        if (!super.equals(o)) return false;
        StudentBursier that = (StudentBursier) o;
        return Double.compare(that.cuantumBursa, cuantumBursa) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cuantumBursa);
    }
    @Override
    public String toString() {
        return super.toString() + ", Bursa: " + cuantumBursa;
    }
    public double getCuantumBursa() {
        return cuantumBursa;
    }
}

