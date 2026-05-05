package main.java.ro.ulbs.proiectare.lab7.def;

public final class Student {
    private final String name;
    private final String formation;

    public Student(String name, String formation) {
        this.name = name;
        this.formation = formation;
    }
    public String getName() {
        return name;
    }

    public String getFormation() {
        return formation;
    }

    public static Student schimbaFormatia(Student st, String nouaFormatie) {
        return new Student(st.getName(), nouaFormatie);
    }
}
