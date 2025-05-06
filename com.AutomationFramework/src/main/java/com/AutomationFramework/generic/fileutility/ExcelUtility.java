package com.AutomationFramework.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file =new FileInputStream("./src/main/resources/tc_data.xlsx");
		
		Workbook wb =WorkbookFactory.create(file);
		
		Sheet sheet = wb.getSheet(sheetName);
		
		Row row = sheet.getRow(rowNum);
		
		String data =  row.getCell(cellNum).getStringCellValue();
		
		wb.close();
		
		return data;
	}
	public void setDataInExcel(String sheetName, int rowNum,int cellNum,String valueToSet) throws EncryptedDocumentException, IOException
	{
		FileInputStream file =new FileInputStream("./src/main/resources/tc_data.xlsx");
		
		Workbook wb =WorkbookFactory.create(file);
		
		Sheet sheet = wb.getSheet(sheetName);
		
		Row row = sheet.getRow(rowNum);
		
		Cell cell = row.createCell(cellNum);
		
		cell.setCellType(CellType.STRING);
		
		cell.setCellValue(valueToSet);
		
		FileOutputStream fos = new FileOutputStream("./src/main/resources/tc_data.xlsx");
		
		wb.write(fos);
		
		wb.close();
	}
	public int getRowCount(String sheetName,int rowNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file =new FileInputStream("./src/main/resources/tc_data.xlsx");
		
		Workbook wb =WorkbookFactory.create(file);
		
		Sheet sheet = wb.getSheet(sheetName);
		
		int count= sheet.getLastRowNum();
		
		wb.close();
		
		return count;
	}
	

}
