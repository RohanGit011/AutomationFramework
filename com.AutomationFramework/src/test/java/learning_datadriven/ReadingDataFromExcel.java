package learning_datadriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingDataFromExcel {
	static String excelPath="./src/main/resources/Practice.xlsx";
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
		FileInputStream file = new FileInputStream(excelPath);
		
		Workbook wb = WorkbookFactory.create(file);
		
		Sheet sheet = wb.getSheet("IPL");
		
		for(int i=1;i<=4;i++)
		{
			for(int j=0;j<=1;j++)
			{
				System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+"\t");
			}
			System.out.println();
		}
		
		String data=sheet.getRow(0).getCell(0).getStringCellValue();
		String data2=sheet.getRow(0).getCell(1).getStringCellValue();
		System.out.println(data);
		System.out.println(data2);
	}
}
