package lab5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileUtils {
    public static void salveazaInFisier(String numeFisier, List<? extends Student> lista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(numeFisier))) {
            for (Student s : lista) {
                writer.write(s.toString());
                writer.newLine();
            }
            System.out.println("Succes: " + numeFisier);
        } catch (IOException e) {
            System.err.println("Eroare: " + e.getMessage());
        }
    }
}
