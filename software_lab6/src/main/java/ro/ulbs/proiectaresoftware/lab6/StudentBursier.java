package ro.ulbs.proiectaresoftware.lab6;

import java.util.Objects;

public class StudentBursier extends Student {
    double cuantumBursa;

    public StudentBursier(int numarMatricol, String prenume, String nume, String formatieDeStudiu, double nota, double bursa) {
        super(numarMatricol, prenume, nume, formatieDeStudiu);
        this.nota = nota;
        this.cuantumBursa = bursa;
    }

    public double getCuantumBursa() {
        return cuantumBursa;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %s [%.2f] [%.2f]", numarMatricol, prenume, nume, formatieDeStudiu, nota, cuantumBursa);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentBursier that = (StudentBursier) o;
        return numarMatricol == that.numarMatricol &&
                Double.compare(that.nota, nota) == 0 &&
                Double.compare(that.cuantumBursa, cuantumBursa) == 0 &&
                Objects.equals(prenume, that.prenume) &&
                Objects.equals(nume, that.nume) &&
                Objects.equals(formatieDeStudiu, that.formatieDeStudiu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numarMatricol, prenume, nume, formatieDeStudiu, nota, cuantumBursa);
    }
}