package learning_datadriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingDataFromExcel3 {
		static String excelPath="C:\\Users\\KIIT\\OneDrive\\Desktop\\names_emails.xlsx";
	
		public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream file = new FileInputStream(excelPath);
		
		Workbook wb = WorkbookFactory.create(file);
		
		Sheet sh = wb.getSheet("Sheet1");
		
		for(int i=0;i<101;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.printf("%10s",sh.getRow(i).getCell(j).getStringCellValue());
			}
			System.out.println();
		}
	}

}
