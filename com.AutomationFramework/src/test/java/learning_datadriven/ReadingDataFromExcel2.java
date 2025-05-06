package learning_datadriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingDataFromExcel2 {
	static String excelPath="./src/main/resources/Untitled spreadsheet (1).xlsx";
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
		FileInputStream file = new FileInputStream(excelPath);
		
		Workbook book = WorkbookFactory.create(file);
		
		Sheet sheet = book.getSheet("Sheet1");
		int count=0;
		
		for(int i=0;i<100;i++)
		{
			for(int j=0;j<=1;j++)
			{
				System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+"\t");
				
			}
			System.out.println();
			count++;
		}
		System.out.println(count);
	}

}
