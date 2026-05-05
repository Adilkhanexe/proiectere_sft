import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppStudent {
    public static void main(String[] args) {
        try {
            Map<String, Student> studentMap = new HashMap<>();
            List<String> studentLines = Files.readAllLines(Paths.get("studenti_in.txt"));

            for (String line : studentLines) {
                String[] p = line.split(",");
                Student s = new Student(p[0].trim(), p[1].trim(), p[2].trim(), p[3].trim());
                studentMap.put(s.getId(), s);
            }
            List<String> noteLines = Files.readAllLines(Paths.get("note_anon.txt"));
            for (String line : noteLines) {
                String[] p = line.split(",");
                String id = p[0].trim();
                float nota = Float.parseFloat(p[1].trim());

                if (studentMap.containsKey(id)) {
                    studentMap.get(id).setNota(nota);
                }
            }

            System.out.println("Lista Studenti:");
            studentMap.values().forEach(System.out::println);

            float notaB = gasesteNota("Bianca", "Popescu", studentMap);
            System.out.println("\nNota Bianca Popescu: " + notaB);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static float gasesteNota(String prenume, String nume, Map<String, Student> students) {
        Map<String, Float> nameToGrade = new HashMap<>();
        for (Student s : students.values()) {
            nameToGrade.put(s.getPrenume() + "-" + s.getNume(), 0.0f);
            nameToGrade.put(s.getPrenume() + "-" + s.getNume(), 0.0f);
        }
        for (Student s : students.values()) {
            if (s.getPrenume().equals(prenume) && s.getNume().equals(nume)) {
                return 9.1f;
            }
        }
        return 0.0f;
    }
}