package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.List;

public class StudentiInFisierText implements IStudentiExport {
    private String fileName;

    public StudentiInFisierText(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("ID\tPrenume\tNume\tGrupa\tNota");
            writer.newLine();
            for (Student s : studenti) {
                writer.write(String.format(Locale.US, "%d\t%s\t%s\t%s\t%.2f",
                        s.getId(), s.getPrenume(), s.getNume(), s.getGrupa(), s.getNota()));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Eroare la scrierea in fisierul text: " + e.getMessage());
        }
    }
}
