package learning_datadriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingEmpData {
	static String excelPath="C:\\Users\\KIIT\\OneDrive\\Desktop\\New folder\\sample_employee_data 1.xlsx";
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream file = new FileInputStream(excelPath);
		
		Workbook wb = WorkbookFactory.create(file);
		
		Sheet sh = wb.getSheet("Employee Data");
		
		int rowCount=sh.getLastRowNum();
		
		for(int i=0;i<=rowCount;i++)
		{
			for(int j=0;j<6;j++) {
				System.out.printf("%5s",sh.getRow(i).getCell(j).toString()+"\t");
			}
			System.out.println();
		}
		
		wb.close();
	}
}
