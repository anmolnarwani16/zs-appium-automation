package reports;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class MobileTestLog {


    private static final String FILE_PATH = "/Users/raramuri/zs-appium-automation/src/main/java/reports/test_execution_log.xlsx";
    private static Workbook workbook;
    private static Sheet sheet;
    private static int rowNum = 0;
    private static boolean initialized = false;
    private static int serialNumber = 1;

    public static void initializeExcelSheet() {
        if (!initialized) {
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("TestExecutionLog");
            rowNum = 0;
            initialized = true;
            writeColumnHeadings();
            rowNum++;
        }
    }

    public static void logTestStep(String testName, String step, String logMessage) {
        initializeExcelSheet();
        String prevTestName = "";
        int prevRowIndex = rowNum - 1;

        while (prevRowIndex > 1 && sheet.getRow(prevRowIndex).getCell(1).getStringCellValue().isEmpty()) {
            prevRowIndex--;
        }

        if (prevRowIndex > 1) {
            prevTestName = sheet.getRow(prevRowIndex).getCell(1).getStringCellValue();
        }

        if (prevTestName.equals(testName)) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue("");
            row.createCell(1).setCellValue("");
            row.createCell(2).setCellValue(step);
            row.createCell(3).setCellValue(logMessage);
        } else {
            rowNum++;
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(serialNumber);
            row.createCell(1).setCellValue(testName);
            row.createCell(2).setCellValue(step);
            row.createCell(3).setCellValue(logMessage);
            serialNumber++;
        }
    }


    public static void saveExcelFile() {
        try (FileOutputStream outputStream = new FileOutputStream(FILE_PATH)) {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeColumnHeadings() {
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Serial Number");
        headerRow.createCell(1).setCellValue("Test Name");
        headerRow.createCell(2).setCellValue("Step");
        headerRow.createCell(3).setCellValue("Log Message");

    }
}
