import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.ulbs.proiectaresoftware.lab6.StudentBursier;
import ro.ulbs.proiectaresoftware.lab6.Group;

import java.util.List;

public class GroupTest {
    Group group;

    @BeforeEach
    public void setup() {
        group = new Group();
        group.addStudent(new StudentBursier(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80, 801.10));
        group.addStudent(new StudentBursier(1025, "Andrei", "Popa", "ISM141/2", 8.70, 725.50));
        group.addStudent(new StudentBursier(1029, "Bianca", "Popescu", "TI131/1", 8.90, 745.50));
        group.addStudent(new StudentBursier(1026, "Anamaria", "Prodan", "TI131/1", 9.10, 780.80));
        group.addStudent(new StudentBursier(1030, "Bianca", "Popescu", "TI131/1", 9.10, 100.00));
    }

    @Test
    public void testSort() {
        group.sortStudents();
        List<StudentBursier> sorted = group.getStudents();
        Assertions.assertEquals("ISM141/1", sorted.get(0).getFormatieDeStudiu());
    }

    @Test
    public void testStudentEquality() {
        StudentBursier s1 = new StudentBursier(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80, 801.10);
        StudentBursier s2 = new StudentBursier(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80, 801.10);

        Assertions.assertEquals(s1, s2);
    }
}