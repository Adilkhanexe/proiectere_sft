package org.example.strategy;

import java.util.List;

public class StudentiInConsola implements IStudentiExport {
    @Override
    public void doExport(List<Student> studenti) {
        System.out.println("Lista Studenti (Consola):");
        System.out.printf("%-6s | %-12s | %-12s | %-10s | %-5s%n", "ID", "Prenume", "Nume", "Grupa", "Nota");
        System.out.println("-----------------------------------------------------------------");
        for (Student s : studenti) {
            System.out.printf("%-6d | %-12s | %-12s | %-10s | %-5.2f%n",
                    s.getId(), s.getPrenume(), s.getNume(), s.getGrupa(), s.getNota());
        }
        System.out.println();
    }
}
