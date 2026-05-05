package org.example;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Creeaza un fisier Excel de test cu date numerice si text.
 * Coloanele A-C sunt text (Nume, Prenume, Grupa),
 * coloanele D-F sunt numerice (Nota1, Nota2, Nota3).
 */
public class SampleDataCreator {

    public static void createSampleInput(String fileName) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Date");

            // Header
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Nr Crt");
            header.createCell(1).setCellValue("Nume");
            header.createCell(2).setCellValue("Prenume");
            header.createCell(3).setCellValue("Nota 1");
            header.createCell(4).setCellValue("Nota 2");
            header.createCell(5).setCellValue("Nota 3");

            // Date
            Object[][] data = {
                    {1, "Popa", "Andrei", 7.0, 8.0, 9.0},
                    {2, "Vecerdea", "Bianca", 7.0, 8.0, 7.0},
                    {3, "Prodan", "Anamaria", 6.0, 9.0, 9.0},
                    {4, "Dumitrescu", "Paul", 9.0, 6.0, 6.0},
                    {5, "Ionescu", "Mihai", 8.0, 8.0, 9.0}
            };

            for (int i = 0; i < data.length; i++) {
                Row row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue((Integer) data[i][0]);
                row.createCell(1).setCellValue((String) data[i][1]);
                row.createCell(2).setCellValue((String) data[i][2]);
                row.createCell(3).setCellValue((Double) data[i][3]);
                row.createCell(4).setCellValue((Double) data[i][4]);
                row.createCell(5).setCellValue((Double) data[i][5]);
            }

            try (FileOutputStream fos = new FileOutputStream(fileName)) {
                workbook.write(fos);
            }
            System.out.println("Fisier input creat: " + fileName);
        } catch (IOException e) {
            System.err.println("Eroare la crearea fisierului: " + e.getMessage());
        }
    }
}
