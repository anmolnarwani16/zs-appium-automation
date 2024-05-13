package reports;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class MobileTestFailure {


    private static final String FILE_PATH = "/Users/raramuri/zs-appium-automation/src/main/java/reports/TestFailure.xlsx";
    private static Workbook workbook;
    private static Sheet sheet;
    private static int rowNum = 0;
    private static boolean initialized = false;
    private static int serialNumber = 1;

    public static void initializeExcelSheet() {
        if (!initialized) {
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("TestFailure_log");
            rowNum = 0;
            initialized = true;
            writeColumnHeadings();
            rowNum++;
        }
    }

    public static void logTestStep(String testName,String logMessage) {
        initializeExcelSheet(); // Ensure the sheet is initialized
            rowNum++;
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(serialNumber);
            row.createCell(1).setCellValue(testName);
            row.createCell(2).setCellValue(logMessage);
            serialNumber++;
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
        headerRow.createCell(2).setCellValue("Log Message");

    }
}
