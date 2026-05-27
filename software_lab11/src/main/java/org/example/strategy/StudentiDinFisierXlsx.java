package org.example.strategy;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentiDinFisierXlsx implements IStudentiImport {
    private String fileName;

    public StudentiDinFisierXlsx(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Student> doImport() {
        List<Student> students = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream(fileName);
             Workbook workbook = new XSSFWorkbook(fileIn)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            // Skip header row
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                
                Cell cellId = row.getCell(0);
                Cell cellPrenume = row.getCell(1);
                Cell cellNume = row.getCell(2);
                Cell cellGrupa = row.getCell(3);
                Cell cellNota = row.getCell(4);

                if (cellId == null || cellPrenume == null || cellNume == null || cellGrupa == null || cellNota == null) {
                    continue;
                }

                int id = (int) cellId.getNumericCellValue();
                String prenume = cellPrenume.getStringCellValue();
                String nume = cellNume.getStringCellValue();
                String grupa = cellGrupa.getStringCellValue();
                double nota = cellNota.getNumericCellValue();

                students.add(new Student(id, prenume, nume, grupa, nota));
            }
        } catch (IOException e) {
            System.err.println("Eroare la citirea din fisierul Excel: " + e.getMessage());
        }
        return students;
    }
}
