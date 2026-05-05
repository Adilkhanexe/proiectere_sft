package org.example;

import java.util.Objects;

public class StudentBursier extends Student {
    private double bursa;

    public StudentBursier(int id, String nume, String prenume, String grupa, double medie, double bursa) {
        super(id, nume, prenume, grupa, medie);
        this.bursa = bursa;
    }

    public double getBursa() { return bursa; }

    @Override
    public String toString() {
        return super.toString() + ", Bursa: " + bursa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentBursier that = (StudentBursier) o;
        return Double.compare(that.bursa, bursa) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bursa);
    }
}
