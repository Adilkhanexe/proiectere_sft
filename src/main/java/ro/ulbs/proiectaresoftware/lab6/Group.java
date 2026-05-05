package ro.ulbs.proiectaresoftware.lab6;

import java.util.ArrayList;
import java.util.List;

public class Group {
    List<StudentBursier> students;

    public Group() {
        this.students = new ArrayList<>();
    }
    public void addStudent(StudentBursier student) {
        students.add(student);
    }
    public void sortStudents() {
        students.sort((s1, s2) -> {
            int res = s1.getFormatieDeStudiu().compareTo(s2.getFormatieDeStudiu());
            if (res != 0) return res;

            res = s1.getNume().compareTo(s2.getNume());
            if (res != 0) return res;

            res = s1.getPrenume().compareTo(s2.getPrenume());
            if (res != 0) return res;

            res = Double.compare(s1.getNota(), s2.getNota());
            if (res != 0) return res;
            return Double.compare(s1.getCuantumBursa(), s2.getCuantumBursa());
        });
    }

    public List<StudentBursier> getStudents() {
        return students;
    }
}