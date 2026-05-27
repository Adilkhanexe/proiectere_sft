package org.example.strategy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierText implements IStudentiImport {
    private String fileName;

    public StudentiDinFisierText(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Student> doImport() {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine(); // Read header line
            if (line == null) {
                return students;
            }
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] parts = line.split("\t");
                if (parts.length == 5) {
                    int id = Integer.parseInt(parts[0].trim());
                    String prenume = parts[1].trim();
                    String nume = parts[2].trim();
                    String grupa = parts[3].trim();
                    double nota = Double.parseDouble(parts[4].trim());
                    students.add(new Student(id, prenume, nume, grupa, nota));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Eroare la citirea din fisierul text: " + e.getMessage());
        }
        return students;
    }
}
