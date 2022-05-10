package com.vTigerGenericlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDatafromExcel1 
{
	
	public String ReadStringvalve( String Sheet, int row, int cellno) throws Throwable{
		String excelpath = "D:\\seleni\\SDET_TEST_06\\SalaryData.xlsx";
		FileInputStream	fr = new FileInputStream(excelpath);
	     Workbook wb = WorkbookFactory.create(fr);
		 String val = wb.getSheet(Sheet).getRow(row).getCell(cellno).getStringCellValue(); 
		 return val ;
	}
	public int Readintvalve(String Sheet, int row, int cellno) throws Throwable{
		String excelpath = "D:\\seleni\\SDET_TEST_06\\SalaryData.xlsx";
		FileInputStream	fr = new FileInputStream(excelpath);
	     Workbook wb = WorkbookFactory.create(fr);
		 int val1 = (int) wb.getSheet(Sheet).getRow(row).getCell(cellno).getNumericCellValue(); 
		 return val1 ;
	}
	
	public int getLastRow(String Sheet) throws Throwable{
		String excelpath = "D:\\seleni\\SDET_TEST_06\\SalaryData.xlsx";
		FileInputStream	fr = new FileInputStream(excelpath);
	     Workbook wb = WorkbookFactory.create(fr);
		 int val2 = (int) wb.getSheet(Sheet).getLastRowNum(); 
		 return val2 ;
	}

//	public String ReadDatafromExcel() throws Throwable{
//		String excelpath = "D:\\seleni\\SDET_TEST_06\\SalaryData.xlsx";
//		FileInputStream	fr = new FileInputStream(excelpath);
//	     Workbook wb = WorkbookFactory.create(fr);
//		 String val = wb.getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue(); 
//		 return val ;
	
}


