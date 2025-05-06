package learning_datadriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadConditionSpecificData {
	static String excelPath="C:\\Users\\KIIT\\OneDrive\\Desktop\\New folder\\sample_employee_data 1.xlsx";
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream file = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet("Employee Data");
		
		int rowCount=sh.getLastRowNum();
		String expectedName="rohan";
	
		boolean flag= false;
		int count=1;
		
		for(int i=0;i<=rowCount;i++)
		{
			int j=1;
			String data=sh.getRow(i).getCell(j).toString();
			if(data.equalsIgnoreCase(expectedName)) {
				if(count==1) {
					for(int a=0;a<6;a++)
					{
						int b=0;
						System.out.printf("%10s",sh.getRow(b).getCell(a).toString()+"\t");
					}
					System.out.println();
					count++;
				}
				flag=true;
				for(int k=0;k<6;k++)
				{
					System.out.printf("%10s",sh.getRow(i).getCell(k).toString()+"\t");
				}
				System.out.println();
			}
		}
		if(flag==false)
			System.out.println(expectedName+" is not present");
		wb.close();
	}

}
