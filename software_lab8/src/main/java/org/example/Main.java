package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String inputFile = "laborator8_input.xlsx";

        // Creare fisier input pentru testare
        SampleDataCreator.createSampleInput(inputFile);

        // 8.5.1 - Citire si afisare in consola
        System.out.println("=== 8.5.1 - Citire fisier Excel ===");
        ExcelReader.readAndDisplay(inputFile);

        // 8.5.2 - Copiere cu medie calculata
        System.out.println("\n=== 8.5.2 - Generare output2 cu medie calculata ===");
        ExcelGenerator.generateWithComputedAverage(inputFile, "laborator8_output2.xlsx");

        // 8.5.3 - Copiere cu formula AVERAGE
        System.out.println("\n=== 8.5.3 - Generare output3 cu formula AVERAGE ===");
        ExcelGenerator.generateWithAverageFormula(inputFile, "laborator8_output3.xlsx");

        // 8.5.4 - Export si import studenti
        System.out.println("\n=== 8.5.4 - Export studenti in .xls ===");
        List<StudentBursier> studenti = new ArrayList<>();
        studenti.add(new StudentBursier(1025, "Andrei", "Popa", "ISM141/2", 8.70, 725.50));
        studenti.add(new StudentBursier(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80, 801.10));
        studenti.add(new StudentBursier(1026, "Anamaria", "Prodan", "TI131/1", 8.90, 745.50));
        studenti.add(new StudentBursier(1029, "Bianca", "Popescu", "TI131/1", 9.10, 780.80));

        String studentsFile = "laborator8_students.xls";
        StudentExcelUtils.exportToExcel(studentsFile, studenti);

        System.out.println("\n=== 8.5.4 - Import studenti din .xls ===");
        List<Student> importati = StudentExcelUtils.importFromExcel(studentsFile);
        importati.forEach(System.out::println);
    }
}
