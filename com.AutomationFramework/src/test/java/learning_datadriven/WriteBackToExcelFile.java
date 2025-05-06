package learning_datadriven;

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

public class WriteBackToExcelFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream file = new FileInputStream("C:\\Users\\KIIT\\OneDrive\\Desktop\\New folder\\sample_employee_data 1.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		
		Sheet sh = wb.getSheet(" ");
		
		Row row = sh.getRow(1);
		
		Cell cell = row.createCell(2);
		
		cell.setCellType(CellType.STRING);
		cell.setCellValue("gfhjkj");
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\KIIT\\OneDrive\\Desktop\\New folder\\sample_employee_data 1.xlsx");
		wb.write(fos);
		System.out.println("Executed");
	}

}
