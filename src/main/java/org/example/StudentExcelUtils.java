package org.example;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentExcelUtils {

    public static void exportToExcel(String fileName, List<? extends Student> students) {
        try (Workbook workbook = new HSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Studenti");

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("Nume");
            header.createCell(2).setCellValue("Prenume");
            header.createCell(3).setCellValue("Grupa");
            header.createCell(4).setCellValue("Medie");

            for (int i = 0; i < students.size(); i++) {
                Student s = students.get(i);
                Row row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(s.getId());
                row.createCell(1).setCellValue(s.getNume());
                row.createCell(2).setCellValue(s.getPrenume());
                row.createCell(3).setCellValue(s.getGrupa());
                row.createCell(4).setCellValue(s.getMedie());
            }

            for (int i = 0; i < 5; i++) sheet.autoSizeColumn(i);

            try (FileOutputStream fos = new FileOutputStream(fileName)) {
                workbook.write(fos);
            }
            System.out.println("Studenti exportati in: " + fileName);
        } catch (IOException e) {
            System.err.println("Eroare la export: " + e.getMessage());
        }
    }

    public static List<Student> importFromExcel(String fileName) {
        List<Student> students = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(fileName);
             Workbook workbook = new HSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                int id = (int) row.getCell(0).getNumericCellValue();
                String nume = row.getCell(1).getStringCellValue();
                String prenume = row.getCell(2).getStringCellValue();
                String grupa = row.getCell(3).getStringCellValue();
                double medie = row.getCell(4).getNumericCellValue();

                students.add(new Student(id, nume, prenume, grupa, medie));
            }
            System.out.println("Studenti importati din: " + fileName);
        } catch (IOException e) {
            System.err.println("Eroare la import: " + e.getMessage());
        }

        return students;
    }
}
