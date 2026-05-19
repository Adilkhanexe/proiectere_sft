package org.example;

import java.util.Arrays;
import java.util.List;

public class AplicatieCuStrategy {
    public static void main(String[] args) {
        List<Student> studenti = Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISM141/2", 8.70),
                new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 10.0),
                new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90),
                new Student(1029, "Bianca", "Popescu", "TI131/1,", 10.0),
                new Student(1029, "Maria", "Pana", "TI131/2,", 4.10),
                new Student(1029, "Gabriela", "Mohanu", "TI131/2,", 7.33),
                new Student(1029, "Marius", "Nasta", "TI131/2,", 3.20),
                new Student(1029, "Marius", "Nasta", "TI131/1,", 5.12),
                new Student(1029, "Andrei", "Dobrescu", "TI131/2,", 2.22)
        );

        Exporter exporter = new Exporter();

        // a) Export to console
        System.out.println("=== a) Export in Consola ===");
        IStudentiExport strategyConsole = new StudentiInConsola();
        exporter.startExport(strategyConsole, studenti);

        // b) Export to text file
        System.out.println("=== b) Export in Fisier Text ===");
        String textFileName = "studentiStrategyText.txt";
        StudentiInFisierText strategyFisierText = new StudentiInFisierText(textFileName);
        exporter.startExport(strategyFisierText, studenti);
        System.out.println("Datele au fost exportate in " + textFileName + "\n");

        // c) Export to xlsx file
        System.out.println("=== c) Export in Fisier Excel (XLSX) ===");
        String excelFileName = "studentiStrategyExcel.xlsx";
        StudentiInFisierXlsx strategyFisierExcel = new StudentiInFisierXlsx(excelFileName);
        exporter.startExport(strategyFisierExcel, studenti);
        System.out.println("Datele au fost exportate in " + excelFileName + "\n");

        Importer importer = new Importer();

        // d) Import from text file
        System.out.println("=== d) Import din Fisier Text ===");
        StudentiDinFisierText strategyCitireText = new StudentiDinFisierText(textFileName);
        List<Student> studentiImportatiText = importer.startImport(strategyCitireText);
        System.out.println("Studentii importati din fisierul text:");
        for (Student s : studentiImportatiText) {
            System.out.println(s);
        }
        System.out.println();

        // e) Import from xlsx file
        System.out.println("=== e) Import din Fisier Excel (XLSX) ===");
        StudentiDinFisierXlsx strategyCitireExcel = new StudentiDinFisierXlsx(excelFileName);
        List<Student> studentiImportatiExcel = importer.startImport(strategyCitireExcel);
        System.out.println("Studentii importati din fisierul Excel:");
        for (Student s : studentiImportatiExcel) {
            System.out.println(s);
        }
        System.out.println();
        
        // Verify correctness
        boolean matchText = verifyListsEqual(studenti, studentiImportatiText);
        boolean matchExcel = verifyListsEqual(studenti, studentiImportatiExcel);
        
        System.out.println("=== Rezultate Verificare ===");
        System.out.println("Integritate date importate din fisier Text: " + (matchText ? "SUCCES" : "ESEC"));
        System.out.println("Integritate date importate din fisier Excel: " + (matchExcel ? "SUCCES" : "ESEC"));
    }

    private static boolean verifyListsEqual(List<Student> original, List<Student> imported) {
        if (original.size() != imported.size()) {
            return false;
        }
        for (int i = 0; i < original.size(); i++) {
            Student s1 = original.get(i);
            Student s2 = imported.get(i);
            if (s1.getId() != s2.getId() ||
                !s1.getPrenume().equals(s2.getPrenume()) ||
                !s1.getNume().equals(s2.getNume()) ||
                !s1.getGrupa().equals(s2.getGrupa()) ||
                Math.abs(s1.getNota() - s2.getNota()) > 0.001) {
                return false;
            }
        }
        return true;
    }
}
