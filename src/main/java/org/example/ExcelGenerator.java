package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelGenerator {

    public static void generateWithComputedAverage(String inputFile, String outputFile) {
        try (FileInputStream fis = new FileInputStream(inputFile);
             Workbook inputWorkbook = new XSSFWorkbook(fis);
             Workbook outputWorkbook = new XSSFWorkbook()) {

            Sheet inputSheet = inputWorkbook.getSheetAt(0);
            Sheet outputSheet = outputWorkbook.createSheet("Date");

            for (Row inputRow : inputSheet) {
                Row outputRow = outputSheet.createRow(inputRow.getRowNum());
                int lastCellNum = inputRow.getLastCellNum();

                copyRow(inputRow, outputRow, lastCellNum);

                if (inputRow.getRowNum() == 0) {
                    outputRow.createCell(lastCellNum).setCellValue("Medie");
                } else {
                    double average = calculateAverage(inputRow, lastCellNum);
                    outputRow.createCell(lastCellNum).setCellValue(average);
                }
            }

            writeWorkbook(outputWorkbook, outputFile);
        } catch (IOException e) {
            System.err.println("Eroare: " + e.getMessage());
        }
    }

    public static void generateWithAverageFormula(String inputFile, String outputFile) {
        try (FileInputStream fis = new FileInputStream(inputFile);
             Workbook inputWorkbook = new XSSFWorkbook(fis);
             Workbook outputWorkbook = new XSSFWorkbook()) {

            Sheet inputSheet = inputWorkbook.getSheetAt(0);
            Sheet outputSheet = outputWorkbook.createSheet("Date");

            for (Row inputRow : inputSheet) {
                Row outputRow = outputSheet.createRow(inputRow.getRowNum());
                int lastCellNum = inputRow.getLastCellNum();

                copyRow(inputRow, outputRow, lastCellNum);

                if (inputRow.getRowNum() == 0) {
                    outputRow.createCell(lastCellNum).setCellValue("Medie");
                } else {
                    int excelRow = inputRow.getRowNum() + 1;
                    String startCol = getColumnLetter(lastCellNum - 3);
                    String endCol = getColumnLetter(lastCellNum - 1);
                    String formula = "AVERAGE(" + startCol + excelRow + ":" + endCol + excelRow + ")";
                    outputRow.createCell(lastCellNum).setCellFormula(formula);
                }
            }

            writeWorkbook(outputWorkbook, outputFile);
        } catch (IOException e) {
            System.err.println("Eroare: " + e.getMessage());
        }
    }

    private static void copyRow(Row source, Row target, int cellCount) {
        for (int c = 0; c < cellCount; c++) {
            Cell inputCell = source.getCell(c);
            Cell outputCell = target.createCell(c);
            if (inputCell != null) {
                copyCellValue(inputCell, outputCell);
            }
        }
    }

    private static void copyCellValue(Cell source, Cell target) {
        switch (source.getCellType()) {
            case STRING:
                target.setCellValue(source.getStringCellValue());
                break;
            case NUMERIC:
                target.setCellValue(source.getNumericCellValue());
                break;
            case BOOLEAN:
                target.setCellValue(source.getBooleanCellValue());
                break;
            case FORMULA:
                target.setCellFormula(source.getCellFormula());
                break;
            default:
                break;
        }
    }

    private static double calculateAverage(Row row, int lastCellNum) {
        double sum = 0;
        int count = 0;
        for (int c = lastCellNum - 3; c < lastCellNum; c++) {
            Cell cell = row.getCell(c);
            if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                sum += cell.getNumericCellValue();
                count++;
            }
        }
        return count > 0 ? sum / count : 0;
    }

    private static String getColumnLetter(int colIndex) {
        StringBuilder sb = new StringBuilder();
        while (colIndex >= 0) {
            sb.insert(0, (char) ('A' + colIndex % 26));
            colIndex = colIndex / 26 - 1;
        }
        return sb.toString();
    }

    private static void writeWorkbook(Workbook workbook, String fileName) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            workbook.write(fos);
        }
        System.out.println("Fisier generat: " + fileName);
    }
}
