package com.banking.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xutils {

	public static int readRowCount(String excelPath, String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		int row = sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return row;
	}
	
	public static int readCellCount(String excelPath, String sheetName,int rowcount) throws IOException
	{
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowcount);
		int cell = row.getLastCellNum();
		workbook.close();
		fis.close();
		return cell;
		
	}
}
