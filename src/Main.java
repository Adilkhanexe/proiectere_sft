import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        students.add(new Student(120, "Alis", "Popa", "TI21/2"));
        // b
        Student s1 = new Student(120, "Alis", "Popa", "TI21/2");
        System.out.println("Alis este: " + checkStudent(students, s1));
        // c
        Student s2 = new Student(112, "Maria", "Popa", "TI21/1");
        System.out.println("Maria este: " + checkStudent(students, s2));
    }
    public static boolean checkStudent(Set<Student> set, Student s) {
        return set.contains(s); //
    }
}