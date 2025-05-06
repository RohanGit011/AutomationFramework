package learning_datadriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class HandleEmptyCells {
	
	static String excelPath="C:\\Users\\KIIT\\OneDrive\\Desktop\\New folder\\sample_employee_data_with_gaps.xlsx";

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream file = new FileInputStream(excelPath);
		
		Workbook wb = WorkbookFactory.create(file);
		
		Sheet sh = wb.getSheet("Employee Data With Gaps");
		
		int rowCount= sh.getLastRowNum();
		
		for(int i=0;i<=rowCount;i++)
		{
			for(int j=0;j<6;j++)
			{
				String data="";
				try {
					data=sh.getRow(i).getCell(j).toString();
				}
				catch(Exception e)
				{
					
				}
				System.out.printf("%10s",data+"\t");
			}
			System.out.println();
		}
		
	}

}
