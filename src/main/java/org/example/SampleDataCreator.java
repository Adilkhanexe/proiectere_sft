package org.example;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class SampleDataCreator {

    public static void createSampleInput(String fileName) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Date");

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Nume");
            header.createCell(1).setCellValue("Prenume");
            header.createCell(2).setCellValue("Grupa");
            header.createCell(3).setCellValue("Nota1");
            header.createCell(4).setCellValue("Nota2");
            header.createCell(5).setCellValue("Nota3");

            Object[][] data = {
                    {"Popescu", "Ion", "ISM141/1", 8.5, 9.0, 7.5},
                    {"Ionescu", "Maria", "ISM141/2", 9.0, 8.5, 9.5},
                    {"Georgescu", "Andrei", "TI131/1", 7.0, 6.5, 8.0},
                    {"Marinescu", "Elena", "TI131/2", 10.0, 9.5, 9.0},
                    {"Vasilescu", "Dan", "ISM141/1", 6.0, 7.0, 5.5}
            };

            for (int i = 0; i < data.length; i++) {
                Row row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue((String) data[i][0]);
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
