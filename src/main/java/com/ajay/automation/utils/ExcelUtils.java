package com.ajay.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static FileInputStream file;
	private static XSSFSheet sheet;
	private static XSSFWorkbook workbook;

	public static void loadExcel(String filePath, String sheetName) {

		try {
			file = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheet(sheetName);
			if(sheet == null) {
				throw new RuntimeException("Sheet:" + sheetName+ "is not found in "+ filePath);
			}

		}

		catch(Exception e) {
			System.out.println("Could not load the Excel file. Please check the path and try again.");
			e.printStackTrace();

		}
	}

	public static String getCellData(int rowNum, int colNum) {
//		return sheet.getRow(rowNum).getCell(colNum).toString();
		
		DataFormatter formatter = new DataFormatter();
		Row row = sheet.getRow(rowNum);
		if(row ==  null) {
			return "";
		}
		
		Cell cell = row.getCell(colNum);
		return (cell ==null) ? "" : formatter.formatCellValue(cell);

	}

	public static String getCellData(int rowNum, String colName) {
		int colNum = -1;
		for (int i=0; i<sheet.getRow(0).getLastCellNum(); i++) {
			if(sheet.getRow(0).getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName.trim())){
				colNum = i;
				break;
			}

		}

		return sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
	}
	
	public static void closeWorkbook() {
		if(workbook != null) {
			try {
				workbook.close();
			}
			
			catch(IOException e) {
				e.printStackTrace();
				
			}
		}
	}
	
	public static void closeFileInputStream() {
		if(file != null) {
			try {
				file.close();
			}
			
			catch(IOException e) {
				e.printStackTrace();
				
			}
		}
	}

}
